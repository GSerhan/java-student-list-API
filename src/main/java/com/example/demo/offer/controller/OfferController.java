package com.example.demo.offer.controller;
import com.example.demo.offer.model.Offer;

import com.example.demo.offer.service.OfferService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getOffers() {
        return new ResponseEntity<>(this.offerService.getOffers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        return new ResponseEntity<>(this.offerService.createOffer(offer), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{offerId}")
    public ResponseEntity<?> deleteOffer(@PathVariable("offerId") Long offerId) {
        return new ResponseEntity<>(this.offerService.deleteOffer(offerId), HttpStatus.OK);
    }

    @PutMapping(path = "{offerId}")
    public void updateOffer(@PathVariable("offerId") Long offerId,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) Boolean favorite,
                            @RequestParam(required = false) Double cashback,
                            @RequestParam(required = false) String shopLink
                            ) {
        this.offerService.updateOffer(offerId, name, favorite, cashback, shopLink);
    }
}
