package com.johnbwhitejr.target.casestudy.repositories;

import com.johnbwhitejr.target.casestudy.beans.Price;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, Long> {
}
