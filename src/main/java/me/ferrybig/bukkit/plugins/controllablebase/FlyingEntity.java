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
public abstract class FlyingEntity {

    protected abstract void onTick(SimpleEntity block, SimpleDirection targetVector, SimpleDirection speedVector);
    private static final double MAX_SPEED = 2;
    private static final double MAX_SPEED_SQUARED = MAX_SPEED * MAX_SPEED;
    private static final double SPEED_MODIFER_AFTER = 1.0;
    private static final double SPEED_MODIFER_BEFORE = 0.5;

    protected SimpleDirection normalizeSpeed(SimpleEntity entity, SimpleDirection targetVector, SimpleDirection speedVector) {
        SimpleDirection v = targetVector.clone().subtract(entity.getLocation());
        v.multiply(SPEED_MODIFER_BEFORE);
        if (v.lengthSquared() > MAX_SPEED_SQUARED) {
            double length = v.length() / MAX_SPEED;
            v.multiply(1 / length);
            //System.out.println(v.lengthSquared());
        }
        v.add(speedVector.multiply(1.7));
        v.multiply(1f / 3);
        v.multiply(SPEED_MODIFER_AFTER);
        return v;
    }

    public abstract void setTargetLocation(SimpleDirection targetBlock);
    
    public abstract void setTargetVector(SimpleDirection targetVector);
    
    public abstract void getTargetLocation();
    
    public abstract void getTargetVector();

     
}
