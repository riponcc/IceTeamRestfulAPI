package com.ripon.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Rest Controller for Player 
 * Submission Date: Nov 13, 2025
 */

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Get all players
    @GetMapping("/players")
    public Iterable<Player> getAllPlayers() {
        return playerService.getPlayers();
    }

    // Get player by ID
    @GetMapping("/player/{playerId}")
    public Player getPlayer(@PathVariable("playerId") int playerId) throws Exception {
        return playerService.getPlayer(playerId);
    }

    //Add new player
    @PostMapping(value = "/player", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayer(@RequestBody Player player) throws Exception {
        playerService.addPlayer(player);
    }

    //Update existing player
    @PutMapping(value = "/player/{playerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) throws Exception {
        player.setPlayerId(playerId);
        playerService.updatePlayer(player);
    }

    // Delete player by ID
    @DeleteMapping("/player/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayer(@PathVariable("playerId") int playerId) throws Exception {
        playerService.deletePlayer(playerId);
    }
}

