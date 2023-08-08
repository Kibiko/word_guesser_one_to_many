package com.demos.bnta.word_guesser.controllers;

import com.demos.bnta.word_guesser.models.Player;
import com.demos.bnta.word_guesser.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id){
        Optional<Player> player = playerService.getPlayerById(id);
        if(player.isPresent()){
            return new ResponseEntity<>(player.get(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Player> addNewPlayer(@RequestBody Player player){ //only the name is needed
        Player savedPlayer = playerService.savePlayer(player); //player object then is saved with list of games and id
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}
