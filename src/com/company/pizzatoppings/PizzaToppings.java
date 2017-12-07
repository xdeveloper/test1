/*
 * In Samsung Ukraine R&D Center (SRK under a contract between)
 * LLC "Samsung Electronics Co", Ltd (Seoul, Republic of Korea)
 * Copyright (C) 2017 Samsung Electronics Co., Ltd. All rights reserved.
 */
package com.company.pizzatoppings;

/**
 * <h1>PizzaToppings</h1>
 *
 * @author <A HREF="mailto:o.abakumov@samsung.com">Oleksandr Abakumov</A>
 * @version 1.0
 * @since 2017-12-07
 */
public class PizzaToppings {

    private static Topping[][] results;

    public static void run() {
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
        };

        search(80, 85, toppings);
        report();
    }

    private static void report() {
        if (results == null || results.length == 0) {
            System.out.println("Немає варіантів");
            return;
        }
        System.out.println("Всього варіантів: " + results.length);
        System.out.println();

        for (Topping[] pizza : results) {
            System.out.println("Всього - " + sum(pizza) + " грн.");
            arrPrint(pizza);
        }
    }

    private static int sum(Topping[] pizza) {
        int sum = 0;
        for (Topping topping : pizza) {
            sum += topping.getPrice();
        }
        return sum;
    }

    private static void search(int low, int high, Topping[] toppings) {
        verifyAndSave(low, high, toppings);
        search0(low, high, new Topping[0], toppings);
    }

    private static void verifyAndSave(int l, int h, Topping[] toppings) {
        if (toppings.length == 0) {
            return;
        }
        int total = 0;
        for (Topping topping : toppings) {
            int price = topping.getPrice();
            total += price;
        }
        if (total >= l && total <= h) {
            if (notInResults(toppings)) {
                save(toppings);
            }
        }
    }

    private static boolean notInResults(Topping[] toppings) {
        if (results == null) {
            return true;
        }
        for (Topping[] result : results) {
            if (theSame(result, toppings)) {
                return false;
            }
        }
        return true;
    }

    private static boolean theSame(Topping[] thiz, Topping[] that) {
        if (thiz.length != that.length) {
            return false;
        }
        for (Topping thizTopping : thiz) {
            if (!contains(thizTopping, that)) {
                return false;
            }
        }
        for (Topping thatTopping : that) {
            if (!contains(thatTopping, thiz)) {
                return false;
            }
        }
        return true;
    }

    private static boolean contains(Topping e, Topping[] arr) {
        for (Topping topping : arr) {
            if (topping.getType().equals(e.getType())) {
                return true;
            }
        }
        return false;
    }

    private static void save(Topping[] toppings) {
        if (results == null) {
            results = new Topping[0][];
        }
        Topping[][] newResults = new Topping[results.length + 1][];
        int c = 0;
        for (Topping[] toppingsOld : results) {
            newResults[c] = toppingsOld;
            c++;
        }
        newResults[newResults.length - 1] = toppings;
        results = newResults;
    }

    private static void search0(int low, int high, Topping[] left, Topping[] right) {
        if (!empty(right)) {
            for (int i = 0; i < right.length; i++) {
                Topping iLeft = right[i];
                Topping[] newRight = append(left, iLeft);
                Topping[] newLeft = exclude(right, i);

                verifyAndSave(low, high, newLeft);

                search0(low, high, newRight, newLeft);
            }
        }
    }

    private static void arrPrint(Topping[] arr) {
        System.out.println("------------------------------------");
        for (Topping topping : arr) {
            System.out.print(topping.toString());
            System.out.print("  ");
        }
        System.out.println("\n------------------------------------\n");
    }

    private static Topping[] exclude(Topping[] arr, int indexToExclude) {
        Topping[] result = new Topping[arr.length - 1];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != indexToExclude) {
                result[c] = arr[i];
                c++;
            }
        }
        return result;
    }

    private static Topping[] append(Topping[] arr, Topping elem) {
        Topping[] result = new Topping[arr.length + 1];
        int c = 0;
        for (Topping topping : arr) {
            result[c] = topping;
            c++;
        }
        result[result.length - 1] = elem;
        return result;
    }

    private static boolean empty(Topping[] arr) {
        for (Topping topping : arr) {
            if (topping != null) {
                return false;
            }
        }
        return true;
    }
}
