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
public class NonMember extends Passenger {

    public NonMember(String name, int age) {
        super(name, age);
    }

    public double applyDiscount(double p) {
        if (age > 65) {
            return p - (0.1 * p);
        } else {
            return p;
        }
    }
}
