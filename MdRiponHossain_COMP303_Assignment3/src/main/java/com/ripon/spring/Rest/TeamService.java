package com.ripon.spring.Rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Service for Team 
 * Submission Date: Nov 13, 2025
 */

@Service
public class TeamService {

    // map the team
    Map<Integer, Team> teamMap = new HashMap<>();

    // Add a new team
    public void addTeam(Team team) throws Exception {
        if (teamMap.containsKey(team.getTeamId())) {
            throw new Exception("This team ID already exists.");
        } else {
            teamMap.put(team.getTeamId(), team);
        }
    }

    // Get all teams
    public Iterable<Team> getTeams() {
        return teamMap.values();
    }

    // Get a team by ID
    public Team getTeam(int teamId) throws Exception {
        if (teamMap.containsKey(teamId)) {
            return teamMap.get(teamId);
        } else {
            throw new Exception("Team ID not found.");
        }
    }

    // Update a team
    public void updateTeam(Team team) throws Exception {
        if (teamMap.containsKey(team.getTeamId())) {
            teamMap.put(team.getTeamId(), team);
        } else {
            throw new Exception("Team ID not found.");
        }
    }

    // Delete a team
    public void deleteTeam(int teamId) throws Exception {
        if (teamMap.containsKey(teamId)) {
            teamMap.remove(teamId);
        } else {
            throw new Exception("Team ID not found.");
        }
    }
}
