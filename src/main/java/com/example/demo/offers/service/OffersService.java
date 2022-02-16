package com.example.demo.offers.service;

import com.example.demo.offers.repository.OffersRepository;

public class OffersService {

    private final OffersRepository offersRepository;

    public OffersService(OffersRepository offersRepository) {
        this.offersRepository = offersRepository;
    }
}
