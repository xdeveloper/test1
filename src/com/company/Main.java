package com.company;

import com.company.pizzatoppings.PizzaToppings;
import com.company.pizzatoppings.Topping;

public class Main {

    public static void main(String args[]) {
        Topping[] toppings = {
                new Topping("сир", 10),
                new Topping("бекон", 20),
                new Topping("помідори", 30),
                new Topping("тунець", 50),
                new Topping("салямі", 40),
                new Topping("кетчуп", 25),
                new Topping("цибуля", 35),
                new Topping("моцарела", 55),
                new Topping("огірок кислий", 25),
                new Topping("ананас", 45),
                new Topping("чилі", 30),
        };

        PizzaToppings.run(150, 165, toppings);
    }
}