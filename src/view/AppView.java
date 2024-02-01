package view;

import java.util.Scanner;
import java.util.Locale;


public class AppView {

    private final Scanner sc = new Scanner(System.in);

    public String[] getData() {
        sc.useLocale(Locale.ENGLISH);
        System.out.println("Please, enter your name");
        String name = sc.nextLine().trim();
        System.out.println("Enter product quantity, pcs");
        String quantity = sc.nextLine().trim();
        System.out.println("Enter product price, USD");
        String price = sc.nextLine().trim();
        System.out.println(
                """
                        Choose delivery option:
                        1 - self-delivery.
                        2 - our delivery(for additional payment).
                        """
        );
        String delivery = sc.nextLine().trim();

        if (Integer.parseInt(delivery) == 2) {
            System.out.println("Please, enter your phone");
        } else{
            System.out.println("Click 'Enter'");}
        String phone = sc.nextLine().trim();

        sc.close();
        return new String[]{name, quantity, price, delivery, phone};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
