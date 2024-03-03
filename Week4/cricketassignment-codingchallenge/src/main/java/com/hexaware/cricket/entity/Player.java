package com.hexaware.cricket.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "player_details")
public class Player {
	
	 @Id
	 @Min(value=100)
	    private Long playerId;

	 @NotBlank(message="Player name must be there")
	    private String playerName;

	    private String jerseyNumber;

	    @NotBlank(message = "Role must be specified")
	    @Pattern(regexp = "^(Batsman|Bowler|All-rounder|Wicket-Keeper)$", message = "Role must be one of: Batsman, Bowler, All-rounder, Wicket-Keeper")
	    private String role;

	    @Min(value=0)
	    private Integer totalMatches;

	    @NotBlank(message = "Team name must be declared")
	    private String teamName;
	    
	    @NotBlank(message = "Country or state name must be declared")

	    private String countryOrStateName;

	    @Size(max = 300, message = "Description cannot exceed 300 characters")
	    private String description;

		public Player() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Player(Long playerId, String playerName, String jerseyNumber, String role, Integer totalMatches,
				String teamName, String countryOrStateName, String description) {
			super();
			this.playerId = playerId;
			this.playerName = playerName;
			this.jerseyNumber = jerseyNumber;
			this.role = role;
			this.totalMatches = totalMatches;
			this.teamName = teamName;
			this.countryOrStateName = countryOrStateName;
			this.description = description;
		}

		public Long getPlayerId() {
			return playerId;
		}

		public void setPlayerId(Long playerId) {
			this.playerId = playerId;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public String getJerseyNumber() {
			return jerseyNumber;
		}

		public void setJerseyNumber(String jerseyNumber) {
			this.jerseyNumber = jerseyNumber;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Integer getTotalMatches() {
			return totalMatches;
		}

		public void setTotalMatches(Integer totalMatches) {
			this.totalMatches = totalMatches;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public String getCountryOrStateName() {
			return countryOrStateName;
		}

		public void setCountryOrStateName(String countryOrStateName) {
			this.countryOrStateName = countryOrStateName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
					+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName
					+ ", countryOrStateName=" + countryOrStateName + ", description=" + description + "]";
		}
	    
	    
	    

}