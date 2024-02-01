package model;

import entity.Purchase;

public class AppFreeDeliveryModel implements AppModel {

    @Override
    public double calcPayment(Purchase purchase) {
        return purchase.getQuota() * purchase.getPrice();
    }
}
