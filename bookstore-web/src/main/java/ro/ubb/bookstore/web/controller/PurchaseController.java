package ro.ubb.bookstore.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bookstore.core.model.Purchase;
import ro.ubb.bookstore.core.service.purchase.PurchaseService;
import ro.ubb.bookstore.web.converter.PurchaseConverter;
import ro.ubb.bookstore.web.dto.PurchaseDto;
import ro.ubb.bookstore.web.dto.PurchasesDto;

@RestController
public class PurchaseController {
    public static final Logger log= LoggerFactory.getLogger(BookController.class);

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseConverter purchaseConverter;


    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    PurchasesDto getPurchases() {
        //todo: log
        return new PurchasesDto(purchaseConverter
                .convertModelsToDtos(purchaseService.getAllPurchases()));

    }

    @RequestMapping(value = "/purchases", method = RequestMethod.POST)
    PurchaseDto savePurchase(@RequestBody PurchaseDto purchaseDto) {
        //todo log
        return purchaseConverter.convertModelToDto(purchaseService.addPurchase(
                purchaseConverter.convertDtoToModel(purchaseDto)
        ));
    }

    @RequestMapping(value = "/purchases/{id}", method = RequestMethod.PUT)
    PurchaseDto updatePurchase(@PathVariable Long id,
                               @RequestBody PurchaseDto purchaseDto) {
        //todo: log
        Purchase purchase = purchaseConverter.convertDtoToModel(purchaseDto);
        return purchaseConverter.convertModelToDto(purchaseService.updatePurchase(new Purchase(id,
                purchase.getBookId(), purchase.getClientId())));
    }

    @RequestMapping(value = "/purchases/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deletePurchase(@PathVariable Long id){
        //todo:log

        purchaseService.removePurchase(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
