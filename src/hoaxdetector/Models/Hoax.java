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
public class Hoax {
    private double membershipHoax;
    private boolean isTrue;

    public Hoax() {
        this.membershipHoax = 0;
        this.isTrue = false;
    }

    public Hoax(double membershipHoax, boolean isTrue) {
        this.membershipHoax = membershipHoax;
        this.isTrue = isTrue;
    }
    
    

    public double getMembershipHoax() {
        return membershipHoax;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public void setMembershipHoax(double membershipHoax) {
        this.membershipHoax = membershipHoax;
    }
    
    
}
