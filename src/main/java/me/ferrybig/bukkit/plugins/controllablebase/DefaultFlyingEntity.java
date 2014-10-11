/*
 * ControllableMinecraftEntities
 * Copyright (C) 2014 Fernando van Loenhout
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.ferrybig.bukkit.plugins.controllablebase;

/**
 *
 * @author Fernando
 */
public class DefaultFlyingEntity {
    private final SimpleEntity bl;
	private SimpleDirection latestSpeed = SimpleDirection.zero();
	private final Listener list = new Listener()
	{
		@EventHandler
		public void onEvent(EntityChangeBlockEvent evt)
		{
			if (evt.getEntity() == bl)
			{
				evt.setCancelled(true);
			}
			if (!bl.isValid())
			{
				EntityChangeBlockEvent.getHandlerList().unregister(this);
			}
		}
	};
	private final int maxTimer;
	private final Location target;
	private int timer;

	/**
	 * contrucs a flying block
	 * <p>
	 * @param block
	 * @param target
	 * @param maxTimer
	 */
	public DefaultFlyingEntity(DefaultFlyingEntity block, Location target, int maxTimer)
	{
		this.bl = block;
		this.target = target;
		this.maxTimer = maxTimer;
	}

	private boolean onTick()
	{
		if (timer++ > this.maxTimer)
		{
			bl.remove();
			return false;
		}
		if (!bl.isValid())
		{
			bl.remove();
			return false;
		}

		//v.divide(DIVIDER);
		bl.setVelocity(this.latestSpeed = this.speed.maxSpeed(bl, target, latestSpeed));
		return true;
	}

	public void start(Plugin pl)
	{
		this.task.runTaskTimer(pl, 1, 1);
		this.bl.setDropItem(false);
		pl.getServer().getPluginManager().registerEvents(list, pl);
	}
}
