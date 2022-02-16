package com.example.demo.offers.controller;

import com.example.demo.offers.service.OffersService;

public class OffersController {

    private final OffersService offersService;

    public OffersController(OffersService offersService) {
        this.offersService = offersService;
    }
}
