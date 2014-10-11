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

import java.util.Random;

/**
 *
 * @author Fernando
 */
public class DefaultSimpleDirection implements  SimpleDirection{
    private static final long serialVersionUID = -2657651106777219169L;

    private static Random random = new Random();

    /**
     * Threshold for fuzzy equals().
     */
    private static final double epsilon = 0.000001;

    protected double x;
    protected double y;
    protected double z;

    public DefaultSimpleDirection() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public DefaultSimpleDirection(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DefaultSimpleDirection(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public DefaultSimpleDirection multiply(int m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @Override
    public DefaultSimpleDirection multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @Override
    public DefaultSimpleDirection multiply(float m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @Override
    public DefaultSimpleDirection normalize() {
        double length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    @Override
    public DefaultSimpleDirection zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public int getBlockX() {
        return NumberConversions.floor(x);
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getBlockY() {
        return NumberConversions.floor(y);
    }

    @Override
    public double getZ() {
        return z;
    }

    /**
     * Gets the floored value of the Z component, indicating the block that
     * this vector is contained with.
     *
     * @return block z
     */
    @Override
    public int getBlockZ() {
        return NumberConversions.floor(z);
    }

    /**
     * Set the X component.
     *
     * @param x The new X component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * Set the X component.
     *
     * @param x The new X component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Set the X component.
     *
     * @param x The new X component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setX(float x) {
        this.x = x;
        return this;
    }

    /**
     * Set the Y component.
     *
     * @param y The new Y component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Y component.
     *
     * @param y The new Y component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Y component.
     *
     * @param y The new Y component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setY(float y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Z component.
     *
     * @param z The new Z component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setZ(int z) {
        this.z = z;
        return this;
    }

    /**
     * Set the Z component.
     *
     * @param z The new Z component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Set the Z component.
     *
     * @param z The new Z component.
     * @return This vector.
     */
    @Override
    public DefaultSimpleDirection setZ(float z) {
        this.z = z;
        return this;
    }

    /**
     * Checks to see if two objects are equal.
     * <p>
     * Only two Vectors can ever return true. This method uses a fuzzy match
     * to account for floating point errors. The epsilon can be retrieved
     * with epsilon.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultSimpleDirection)) {
            return false;
        }

        DefaultSimpleDirection other = (DefaultSimpleDirection) obj;

        return Math.abs(x - other.x) < epsilon && Math.abs(y - other.y) < epsilon && Math.abs(z - other.z) < epsilon && (this.getClass().equals(obj.getClass()));
    }

    /**
     * Returns a hash code for this vector
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;

        hash = 79 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    /**
     * Get a new vector.
     *
     * @return vector
     */
    @Override
    public DefaultSimpleDirection clone() {
        try {
            return (DefaultSimpleDirection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    /**
     * Returns this vector's components as x,y,z.
     */
    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}
