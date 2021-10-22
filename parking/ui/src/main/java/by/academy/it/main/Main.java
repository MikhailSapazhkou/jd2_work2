package by.academy.it.main;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(new java.sql.Date(date.getTime()));
    }
}
