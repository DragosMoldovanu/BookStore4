package ro.ubb.bookstore.core.service.purchase;

import ro.ubb.bookstore.core.model.Purchase;

import java.util.List;

public interface PurchaseService {

    String NAME = "PurchaseService";

    Purchase getPurchaseById(Long id);

    Purchase addPurchase(Purchase purchase);

    void removePurchase(Long id);

    Purchase updatePurchase(Purchase newPurchase);

    List<Purchase> getAllPurchases();
}
