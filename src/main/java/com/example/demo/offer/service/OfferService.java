
package com.example.demo.offer.service;
import com.example.demo.offer.exception.UserNotFoundException;
import com.example.demo.offer.model.Offer;
import com.example.demo.offer.repository.OfferRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer createOffer(Offer offer) {
       Optional<Offer> selectedOffer = offerRepository.findOfferByName(offer.getName());

       if(selectedOffer.isPresent()) {
           throw new IllegalStateException("Name is taken");
       }
        return offerRepository.save(offer);
    }

    public Optional<Offer> deleteOffer(Long id) {
        Optional<Offer> selectedOffer = offerRepository.findById(id);

        if(selectedOffer.isEmpty()) {
            throw new UserNotFoundException("The offer with id " + id + " doesn't exist");
        }
        offerRepository.deleteById(id);
        return selectedOffer;
    }

    @Transactional
    public Offer updateOffer(Long id, String name, Boolean favorite, Double cashback, String shopLink) {
        Offer selectedOffer = offerRepository.findOfferById(id);

        if(name != null && name.length() > 0 && !name.equals(selectedOffer.getName())) {
            selectedOffer.setName(name);
        } else {
            throw new IllegalStateException("Error in name change");
        }

        if(favorite != null && cashback != null && shopLink != null) {
            selectedOffer.setFavorite(favorite);
            selectedOffer.setCashback(cashback);
            selectedOffer.setShopLink(shopLink);
        } else {
            throw new IllegalStateException("Something went wrong");
        }

        return selectedOffer;

    }

}
