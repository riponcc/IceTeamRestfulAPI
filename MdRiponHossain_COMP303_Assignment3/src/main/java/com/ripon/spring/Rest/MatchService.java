package com.ripon.spring.Rest;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Service for Match 
 * Submission Date: Nov 13, 2025
 */

@Service
@Transactional
@AllArgsConstructor
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    // Get all matches
    public Flux<Match> getAll() {
        return matchRepository.findAll().switchIfEmpty(Flux.empty());
    }

    // Get a match by ID
    public Mono<Match> getById(final int id) {
        return matchRepository.findById(id);
    }

    // Save new match
    public Mono save(final Match match) {
        return matchRepository.save(match);
    }

    // Update existing match 
    public Mono update(final int id, final Match match) {
        return matchRepository.save(match);
    }

    // Delete a match by ID 
    public Mono delete(final int id) {

        final Mono<Match> dbMatch = getById(id);
        if (Objects.isNull(dbMatch)) {
            return Mono.empty();
        }

        return getById(id)
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(matchToBeDeleted ->
                        matchRepository.delete(matchToBeDeleted)
                                .then(Mono.just(matchToBeDeleted))
                );
    }
}

