/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Models;

/**
 *
 * @author ghost
 */
public class Provocation {
    private double crispProvocation;
    
    private double fuzzyLow;
    private double fuzzyNormal;
    private double fuzzyHigh;
    
    private boolean low;
    private boolean normal;
    private boolean high;

    public Provocation(double crispProvocation) {
        this.crispProvocation   = crispProvocation;
        this.low              = false;
        this.normal         = false;
        this.high             = false;
        this.fuzzyLow       = 0;
        this.fuzzyNormal  = 0;
        this.fuzzyHigh      = 0;
    }

    public double getCrispProvocation() {
        return crispProvocation;
    }

    public void setCrispProvocation(double crispProvocation) {
        this.crispProvocation = crispProvocation;
    }

    public double getFuzzyLow() {
        return fuzzyLow;
    }

    public void setFuzzyLow(double fuzzyLow) {
        this.fuzzyLow = fuzzyLow;
    }

    public double getFuzzyNormal() {
        return fuzzyNormal;
    }

    public void setFuzzyNormal(double fuzzyNormal) {
        this.fuzzyNormal = fuzzyNormal;
    }

    public double getFuzzyHigh() {
        return fuzzyHigh;
    }

    public void setFuzzyHigh(double fuzzyHigh) {
        this.fuzzyHigh = fuzzyHigh;
    }

    public boolean isLow() {
        return low;
    }

    public void setLow(boolean low) {
        this.low = low;
    }

    public boolean isNormal() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public boolean isHigh() {
        return high;
    }

    public void setHigh(boolean high) {
        this.high = high;
    }

    
}
