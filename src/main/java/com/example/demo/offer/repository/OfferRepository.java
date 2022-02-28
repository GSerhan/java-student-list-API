package com.example.demo.offer.repository;

import com.example.demo.offer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findOfferByName(String name);
    Offer findOfferById(Long id);
}
