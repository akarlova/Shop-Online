package model;

import entity.Purchase;

public class AppPaidDeliveryModel implements AppModel{

double deliveryRATE = 10;
    @Override
    public double calcPayment(Purchase purchase) {
        double basePayment = purchase.getQuota()* purchase.getPrice();
        return basePayment+basePayment*deliveryRATE/100;
    }
    public double getDeliveryCost(Purchase purchase){
        return purchase.getQuota()* purchase.getPrice()*deliveryRATE/100;
    }
}
