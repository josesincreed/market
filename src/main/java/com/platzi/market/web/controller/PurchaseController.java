package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases") // Definimos la URL base para todos los endpoints de este controlador
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")  //mapea acciones HTTP GET a este metodo
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId).map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")  //mapea acciones HTTP POST a este metodo
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
