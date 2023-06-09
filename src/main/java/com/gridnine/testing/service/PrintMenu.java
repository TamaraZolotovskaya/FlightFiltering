package com.gridnine.testing.service;

public class PrintMenu {

    /**
     * Displays a menu with filter types in the console.
     *
     * @see Filter
     * @see FilterMenuMap
     */
    public static void printMenu() {
        System.out.println(
                " 1. вылет до текущего момента времени \n" +
                        " 2. имеются сегменты с датой прилёта раньше даты вылета \n" +
                        " 3. общее время, проведённое на земле превышает два часа \n" +
                        " 0. выход"
        );
    }
}
