package com.ripon.spring.Rest;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Service for Player 
 * Submission Date: Nov 13, 2025
 */

@Service
public class PlayerService {

   Map<Integer, Player> playerMap = new HashMap<>();

    public void addPlayer(Player player) throws Exception {
        if (playerMap.containsKey(player.getPlayerId())) {
            throw new Exception("This player ID already exists.");
        } else {
            playerMap.put(player.getPlayerId(), player);
        }
    }

    public Iterable<Player> getPlayers() {
        return playerMap.values();
    }

    public Player getPlayer(int playerId) throws Exception {
        if (playerMap.containsKey(playerId)) {
            return playerMap.get(playerId);
        } else {
            throw new Exception("Player ID not found.");
        }
    }

    public void updatePlayer(Player player) throws Exception {
        if (playerMap.containsKey(player.getPlayerId())) {
            playerMap.put(player.getPlayerId(), player);
        } else {
            throw new Exception("Player ID not found.");
        }
    }

    public void deletePlayer(int playerId) throws Exception {
        if (playerMap.containsKey(playerId)) {
            playerMap.remove(playerId);
        } else {
            throw new Exception("Player ID not found.");
        }
    }
}
