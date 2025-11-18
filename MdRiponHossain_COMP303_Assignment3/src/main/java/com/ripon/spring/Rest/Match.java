package com.ripon.spring.Rest;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/*
 * Author: Md Ripon Hossain
 * Assignment 3: Building RESTful Web Services for an Ice Hockey League
 * Entity class for Match with all required fields
 * Submission Date: Nov 13, 2025
 */

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Match {
	
	@Id
	private int matchId;           
    private int homeTeamId;
    private int awayTeamId;
    private LocalDate matchDate;
    private String venue;
    private int homeScore;
    private int awayScore;
    
    //Empty Constructor

	public Match() {
		
		super();
		
	}

	//Constructor with parameters
	public Match(int matchId, int homeTeamId, int awayTeamId, LocalDate matchDate, String venue, int homeScore,
			int awayScore) {
		super();
		this.matchId = matchId;
		this.homeTeamId = homeTeamId;
		this.awayTeamId = awayTeamId;
		this.matchDate = matchDate;
		this.venue = venue;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
	}

	//Getter-setter methods
	public int getMatchId() {
		return matchId;
	}


	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}


	public int getHomeTeamId() {
		return homeTeamId;
	}


	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}


	public int getAwayTeamId() {
		return awayTeamId;
	}


	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}


	public LocalDate getMatchDate() {
		return matchDate;
	}


	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}


	public String getVenue() {
		return venue;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}


	public int getHomeScore() {
		return homeScore;
	}


	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}


	public int getAwayScore() {
		return awayScore;
	}


	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
}

	
	