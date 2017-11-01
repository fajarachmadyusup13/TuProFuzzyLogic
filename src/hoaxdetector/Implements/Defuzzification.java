/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Implements;

import hoaxdetector.Models.Hoax;
import hoaxdetector.Utils.Limits;
import hoaxdetector.Utils.Operations;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class Defuzzification implements Operations.defuzzification{

    @Override
    public Hoax countYStarSingle(Hoax h) {
        Hoax hx = new Hoax();
        double yStar = 0;
        if (h.isTrue()) {
            yStar = (Limits.SUGENO_TRUE * h.getMembershipHoax() + 0) / (Limits.SUGENO_TRUE + Limits.SUGENO_FALSE);
        }else {
            yStar = (Limits.SUGENO_FALSE * h.getMembershipHoax() + 0) / (Limits.SUGENO_TRUE + Limits.SUGENO_FALSE);
        }
        hx.setMembershipHoax(yStar);
        if (yStar >= Limits.THRESHOLD) {
            hx.setIsTrue(true);
        }else {
            hx.setIsTrue(false);
        }
        return hx;
    }

    @Override
    public Hoax countYStarMultipe(ArrayList<Hoax> h) {
        Hoax hx = new Hoax();
        double yStar = 0;
        if (h.get(0).isTrue()) {
            yStar = ((Limits.SUGENO_TRUE * h.get(0).getMembershipHoax()) + (Limits.SUGENO_FALSE * h.get(1).getMembershipHoax())) / (Limits.SUGENO_TRUE + Limits.SUGENO_FALSE);
        }else if(h.get(1).isTrue()) {
            yStar = ((Limits.SUGENO_TRUE * h.get(1).getMembershipHoax()) + (Limits.SUGENO_FALSE * h.get(0).getMembershipHoax())) / (Limits.SUGENO_TRUE + Limits.SUGENO_FALSE);
        }
        hx.setMembershipHoax(yStar);
        if (yStar >= Limits.THRESHOLD) {
            hx.setIsTrue(true);
        }else {
            hx.setIsTrue(false);
        }
        return hx;
    }
}
