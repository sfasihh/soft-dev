/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author Samiya Fasihuddin
 */
public class Member extends Passenger {

    public int yearsOfMembership;

    public Member(String name, int age, int years) {
        super(name, age);
        yearsOfMembership = years;
    }

    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            return p - (0.5*p);
        } else if (yearsOfMembership > 1 && yearsOfMembership <= 5) {
            return p - (0.1*p);
        } else {
           return p;
        }
    }

}
