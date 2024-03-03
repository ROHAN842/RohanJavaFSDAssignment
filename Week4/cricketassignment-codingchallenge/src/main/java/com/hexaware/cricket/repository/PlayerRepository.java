package com.hexaware.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.cricket.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Modifying
	@Query("delete from Player p where p.playerName = ?1")
	int deletePlayerByName(String PlayerName);
	
	@Query(value = "SELECT * FROM Player WHERE player_name = :playerName", nativeQuery = true)
    List<Player> findPlayersByName(@Param("playerName") String playerName);
	
//	
//	   @Query("SELECT p FROM Player p WHERE p.teamName = :teamName")
//	    List<Player> findByTeamName(@Param("teamName") String teamName);
	
	 
	 @Query(value = "select player_name from player_details where team_name = ?1", nativeQuery = true)
	 List<String> findPlayersByTeamName(String teamName);
	 
//	@Query(value = "SELECT * FROM player_details WHERE team_name = ?1", nativeQuery = true)
//	List<Player> findPlayersByTeamName(String teamName);



	Player findByPlayerName(String playerName);
}

