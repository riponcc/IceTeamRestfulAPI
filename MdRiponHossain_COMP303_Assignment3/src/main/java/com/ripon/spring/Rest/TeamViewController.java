package com.ripon.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Additional controller to view (Optional)
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Controller for Team to view team in the browser
 * Submission Date: Nov 13, 2025
 */

@Controller
@RequestMapping("/team-page")
public class TeamViewController {

    @Autowired
    private TeamService teamService;

    //Show all teams
    @GetMapping("/home")
    public String viewTeams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "index"; 
    }

    //Show add form
    @GetMapping("/add-team")
    public String showAddTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "add-team";
    }

    //Save new team
    @PostMapping("/save-team")
    public String saveTeam(@ModelAttribute("team") Team team, Model model) {
        try {
            teamService.addTeam(team);
            return "redirect:/team-page/home";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "add-team";
        }
        
        
    }

    // Show edit form
    @GetMapping("/edit/{teamId}")
    public String showEditForm(@PathVariable("teamId") int teamId, Model model) {
        try {
            Team existingTeam = teamService.getTeam(teamId);
            model.addAttribute("team", existingTeam);
            return "edit-team"; 
        } catch (Exception e) {
            model.addAttribute("error", "Team not found!");
            return "redirect:/team-page/home";
        }
    }

    //Update existing team
    @PostMapping("/update-team")
    public String updateTeam(@ModelAttribute("team") Team team, Model model) {
        try {
            teamService.updateTeam(team);
            return "redirect:/team-page/home";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "edit-team";
        }
    }

    //Delete a team
    @GetMapping("/delete/{teamId}")
    public String deleteTeam(@PathVariable("teamId") int teamId) {
        try {
            teamService.deleteTeam(teamId);
        } catch (Exception e) {
        }
        return "redirect:/team-page/home";
    }
}
