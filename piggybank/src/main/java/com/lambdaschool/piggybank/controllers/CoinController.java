package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepos;

    private double cashTotal = 0.00;

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> coinList(){
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);
        for (Coin c : myList){
            if (c.getQuantity() > 1){
                System.out.println(c.getQuantity() + " " + c.getNamepural());
            }
            else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
        }
        for (int i=0; i < myList.size(); i++) {
            cashTotal += myList.get(i).getTotal();
        }
        System.out.println("The piggy bank holds " + cashTotal);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
