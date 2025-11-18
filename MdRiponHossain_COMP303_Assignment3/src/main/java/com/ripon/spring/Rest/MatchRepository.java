package com.ripon.spring.Rest;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Repository for match entity
 * Submission Date: Nov 13, 2025
 */

@Repository
public interface MatchRepository extends ReactiveMongoRepository<Match, Integer> {

}
