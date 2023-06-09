package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;
import java.util.Scanner;

import static com.gridnine.testing.service.FilterMenuMap.filterMenuMap;
import static com.gridnine.testing.service.PrintMenu.printMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Все перелёты:");
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

        while (true) {
            System.out.println("Исключить из перелётов \n" +
                    "Выберите пункт меню:");

            printMenu();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                if (menu == 0) {
                    break;
                } else if (filterMenuMap.containsKey(menu)) {
                    filterMenuMap.get(menu).accept(flights);
                }
            } else {
                scanner.next();
            }
        }
    }


}
