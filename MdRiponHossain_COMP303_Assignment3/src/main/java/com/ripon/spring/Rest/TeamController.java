package com.ripon.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Rest Controller for Team 
 * Submission Date: Nov 13, 2025
 */

@RestController

public class TeamController {

    @Autowired
    TeamService teamService;

    @ResponseBody
    @RequestMapping("")
    public String home() {
        return "A Team Web service created";
    }
   
    // Get a single team by ID
    @RequestMapping(value = "/team/{teamId}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable("teamId") int teamId) throws Exception {
        return teamService.getTeam(teamId);
    }

    // Get all teams
    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public Iterable<Team> getTeams() {
        return teamService.getTeams();
    }

    // Add a new team
    @RequestMapping(value = "/team", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addTeam(@RequestBody Team team) throws Exception {
        teamService.addTeam(team);
    }

    // Update an existing team
    @RequestMapping(value = "/team/{teamId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTeam(@PathVariable("teamId") int teamId, @RequestBody Team team) throws Exception {
        team.setTeamId(teamId);
        teamService.updateTeam(team);
    }

    // Delete a team
    @RequestMapping(value = "/team/{teamId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTeam(@PathVariable("teamId") int teamId) throws Exception {
        teamService.deleteTeam(teamId);
    }
}

