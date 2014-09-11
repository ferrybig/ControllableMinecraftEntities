/*
 * Enderstone
 * Copyright (C) 2014 Sander Gielisse and Fernando van Loenhout
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
public interface SimpleDirection {
    public SimpleDirection add(SimpleDirection vec);

    public SimpleDirection subtract(SimpleDirection vec);

    public SimpleDirection multiply(SimpleDirection vec);

    public SimpleDirection divide(SimpleDirection vec);

    public SimpleDirection copy(SimpleDirection vec);

    public double length();

    public double lengthSquared();

    public double distance(SimpleDirection o);

    public double distanceSquared(SimpleDirection o);

    public float angle(SimpleDirection other);

    public SimpleDirection midpoint(SimpleDirection other);

    public SimpleDirection getMidpoint(SimpleDirection other);

    public SimpleDirection multiply(int m);

    public SimpleDirection multiply(double m);

    public SimpleDirection multiply(float m);

    public double dot(SimpleDirection other);

    public SimpleDirection crossProduct(SimpleDirection o);

    public SimpleDirection normalize();

    public SimpleDirection zero();

    public boolean isInAABB(SimpleDirection min, SimpleDirection max);

    public boolean isInSphere(SimpleDirection origin, double radius);

    public double getX();

    public int getBlockX();

    public double getY();

    public int getBlockY();

    public double getZ();

    public int getBlockZ();

    public SimpleDirection setX(int x);

    public SimpleDirection setX(double x);

    public SimpleDirection setX(float x);

    public SimpleDirection setY(int y);

    public SimpleDirection setY(double y);

    public SimpleDirection setY(float y);

    public SimpleDirection setZ(int z);

    public SimpleDirection setZ(double z);

    public SimpleDirection setZ(float z);

    public SimpleDirection clone();

}
