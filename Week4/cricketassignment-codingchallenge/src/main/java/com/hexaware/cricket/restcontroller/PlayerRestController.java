package com.hexaware.cricket.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.service.IPlayerService;

import jakarta.transaction.Transactional;

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

	Logger logger = LoggerFactory.getLogger(PlayerRestController.class);

    @Autowired
    private IPlayerService playerService;

    @GetMapping("/getall")
    public List<Player> getAllPlayers() {
    	logger.info("Get all players data");
        return playerService.getAllPlayers();
    }

    @PostMapping("/add")
    public Player createPlayer(@RequestBody PlayerDTO playerDTO) {
    	logger.info("Create player method");
        return playerService.createPlayer(playerDTO);
    }

    @GetMapping("/get/{playerId}")
    public Player getPlayerById(@PathVariable Long playerId) throws PlayerNotFoundException {
    	logger.info("Player get by Id method");
        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new PlayerNotFoundException(null, "Player with ID " + playerId + " not found");
        }
        return player;
    }

    @PutMapping("/update/{playerId}")
    public Player updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
    	logger.info("Player update method");
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/deleteByid/{playerId}")
    public void deletePlayer(@PathVariable Long playerId) {
	    try {
	    	logger.info("Player delete method");
	         playerService.deletePlayer(playerId);
	    } catch (Exception e) {
	        logger.error("Error deleting product with ID " + playerId + ": " + e.getMessage());
	        throw new RuntimeException("Error deleting product with ID " + playerId, e);
	    }
    }
    
    @Transactional
    @DeleteMapping("/deleteByName/{playerName}")
    public int deletePlayerByName(@PathVariable String playerName)
    {
    	logger.info("Player deleted by name");
    	return playerService.deletePlayerByName(playerName);
    }



//    @GetMapping("/getbyteamName/{teamName}")
//    public ResponseEntity<List<Player>> getPlayersByTeamName(@PathVariable String teamName) {
//        List<Player> players = playerService.getPlayersByTeamName(teamName);
//        if (players.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(players);
//    }
    
    
//    @GetMapping("/get-players-by-teamname/{teamName}")
//    public List<String> getPlayersByTeamName(@PathVariable String teamName) {
//        return playerService.findPlayersByTeamName(teamName);
//    }
    
    @GetMapping("/get-players-by-teamname/{teamName}")
    public List<String> getPlayersByTeamName(@PathVariable String teamName) {
        return playerService.findPlayersByTeamName(teamName);
    }


 
    
    @GetMapping("/get-by-name/{playerName}")
    public Player getPlayerByName(@PathVariable String playerName) throws PlayerNotFoundException {
        logger.info("Get player by name method");
        Player player = playerService.getPlayerByName(playerName);
        if (player == null) {
            throw new PlayerNotFoundException(null, "Player with name " + playerName + " not found");
        }
        return player;
    }

}
