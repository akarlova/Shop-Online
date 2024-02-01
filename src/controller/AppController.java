package controller;

import entity.Buyer;
import entity.Purchase;
import model.AppFreeDeliveryModel;
import model.AppPaidDeliveryModel;
import utils.Rounder;
import view.AppView;

public class AppController {

    private final static String CURRENCY = "USD ";
    private final AppView view = new AppView();

    public void getPayment() {

        String[] data = view.getData();
        Buyer buyer = getBuyer(data);
        Purchase purchase = getPurchase(data);
        int deliveryOption = getDeliveryOption(data);
        String output;
        String payment;

        if (deliveryOption == 1) {
            AppFreeDeliveryModel delivery = new AppFreeDeliveryModel();
            payment = Rounder.roundValue(delivery.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + "\nPayment: " + CURRENCY +
                    payment + "\nDelivery: free";
            view.getOutput(output);
        } else if (deliveryOption == 2) {
            AppPaidDeliveryModel delivery = new AppPaidDeliveryModel();
            payment = Rounder.roundValue(delivery.calcPayment(purchase));
            String deliveryCost = Rounder.roundValue(delivery.getDeliveryCost(purchase));
            output = "\nBuyer: " + buyer.getName() + "\nPhone: " + buyer.getPhone() +
                    "\nPayment: " + CURRENCY + payment + "\nIncluding delivery: "
                    + CURRENCY + deliveryCost;
            view.getOutput(output);
        }else{
            output ="Try again";
            view.getOutput(output);
        }

    }

    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[4]);
    }

    private Purchase getPurchase(String[] data) {
        return new Purchase(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private int getDeliveryOption(String[] data) {
        return Integer.parseInt(data[3]);
    }
}

