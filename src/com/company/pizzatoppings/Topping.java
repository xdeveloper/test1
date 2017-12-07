/*
 * In Samsung Ukraine R&D Center (SRK under a contract between)
 * LLC "Samsung Electronics Co", Ltd (Seoul, Republic of Korea)
 * Copyright (C) 2017 Samsung Electronics Co., Ltd. All rights reserved.
 */
package com.company.pizzatoppings;

/**
 * <h1>Topping</h1>
 *
 * @author <A HREF="mailto:o.abakumov@samsung.com">Oleksandr Abakumov</A>
 * @version 1.0
 * @since 2017-12-07
 */
public class Topping {
    private final String type;
    private final int price;

    public Topping(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " (" + price + "грн.)";
    }
}
