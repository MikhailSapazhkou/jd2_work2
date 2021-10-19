package by.academy.it.main;

import by.academy.it.controller.Printer;
import by.academy.it.data.Ticket;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(new java.sql.Date(date.getTime()));
    }
}
