package com.hexaware.cricket.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.repository.PlayerRepository;

@Service
public class PlayerServiceImp implements IPlayerService {

    @Autowired
    private PlayerRepository player;

    // Get all player method
    @Override
    public List<Player> getAllPlayers() {
        return player.findAll();
    }

    // Get player by Id method 
    @Override
    public Player getPlayerById(Long playerId) {
        return player.findById(playerId).orElse(null);
    }

    // create or add player method 
    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        Player player1 = new Player();
        player1.setPlayerId(playerDTO.getPlayerId());
        player1.setPlayerName(playerDTO.getPlayerName());
        player1.setJerseyNumber(playerDTO.getJerseyNumber());
        player1.setRole(playerDTO.getRole());
        player1.setTotalMatches(playerDTO.getTotalMatches());
        player1.setTeamName(playerDTO.getTeamName());
        player1.setCountryOrStateName(playerDTO.getCountryOrStateName());
        player1.setDescription(playerDTO.getDescription());
        return player.save(player1);
    }

    // update player method 
    @Override
    public Player updatePlayer(Long playerId, Player player1) {
        player1.setPlayerId(playerId);
        return player.save(player1);
    }

    // delete player method 
    @Override
    public void deletePlayer(Long playerId) {
        player.deleteById(playerId);
    }
    
//    public Map<String, List<Player>> getAllPlayersGroupedByTeam() {
//        List<Object[]> results = player.findAllPlayersWithTeamNames();
//        
//        Map<String, List<Player>> playersByTeam = new HashMap<>();
//        
//        for (Object[] result : results) {
//            String teamName = (String) result[0];
//            Player player = (Player) result[1];
//            
//            playersByTeam.computeIfAbsent(teamName, k -> new ArrayList<>()).add(player);
//        }
//        
//        return playersByTeam;
//    }

	@Override
	public int deletePlayerByName(String playerName) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public List<String> findPlayersByTeamName(String teamName) {
	    return player.findPlayersByTeamName(teamName);
	}



	@Override
	public Player getPlayerByName(String playerName) {
	    return player.findByPlayerName(playerName);
	}





}
