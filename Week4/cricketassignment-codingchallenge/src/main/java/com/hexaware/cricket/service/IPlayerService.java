package com.hexaware.cricket.service;

import java.util.List;
import java.util.Map;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;

public interface IPlayerService {

	public List<Player> getAllPlayers();

    public Player getPlayerById(Long playerId);

   public Player createPlayer(PlayerDTO playerDTO);

   public Player updatePlayer(Long playerId, Player player);

  public void deletePlayer(Long playerId) throws PlayerNotFoundException;
    
    public int deletePlayerByName(String playerName);


public List<String> findPlayersByTeamName(String teamName);

public Player getPlayerByName(String playerName);
}
