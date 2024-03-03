package com.hexaware.cricket.dto;

public class PlayerDTO {
	
	private Long playerId;
    private String playerName;
    private String jerseyNumber;
    private String role;
    private Integer totalMatches;
    private String teamName;
    private String countryOrStateName;
    private String description;
    
	public PlayerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerDTO(Long playerId, String playerName, String jerseyNumber, String role, Integer totalMatches,
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
		return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName
				+ ", countryOrStateName=" + countryOrStateName + ", description=" + description + "]";
	}


    
	
	
    
    

}
