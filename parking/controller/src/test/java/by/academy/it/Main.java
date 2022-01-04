package by.academy.it;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = null;
        try {
            main = new Main();
            System.out.println(main.average(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<Integer> list1 = new ArrayList<>();
            list1.add(null);
            System.out.println(main.average(list1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(null);
            list1.add(2);
            list1.add(null);

            System.out.println(main.average(list1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double average(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            System.out.println("List is empty");
            throw new IllegalArgumentException("List is empty");
        }
        int size = values.size();
        int sum = 0;
        for (Integer value : values) {
            if (value == null) {
                size--;
                continue;
            }

            sum += value;

        }
        return (double) sum / size;
    }

}
