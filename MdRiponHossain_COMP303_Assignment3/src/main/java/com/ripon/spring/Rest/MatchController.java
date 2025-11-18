
package com.ripon.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Rest Controller for Player 
 * Submission Date: Nov 13, 2025
 */


@RequestMapping("match")
@AllArgsConstructor
@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    // Get all matches
    @GetMapping
    public Flux<Match> getAll() {
        System.out.println("All match information");
        return matchService.getAll();
    }

    // Get match by ID
    @GetMapping("{id}")
    public Mono<Match> getById(@PathVariable("id") final int id) {
        System.out.println("One match information based on the given ID");
        return matchService.getById(id);
    }

    // Update match
    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") final int id,
                                  @RequestBody final Match match) {
        System.out.println("Updating match information");
        return matchService.update(id, match);
    }

    // Save new match
    @PostMapping
    public Mono save(@RequestBody final Match match) {
        System.out.println(
            "Added match Info: Home Team " + match.getHomeTeamId() +
            " - Away Team " + match.getAwayTeamId() +
            " - Venue " + match.getVenue() +
            " - Date " + match.getMatchDate()
        );
        return matchService.save(match);
    }

    // Delete match
    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") final int id) {
        System.out.println("A match info deleted");
        return matchService.delete(id);
    }
}
