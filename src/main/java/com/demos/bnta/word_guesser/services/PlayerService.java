package com.demos.bnta.word_guesser.services;

import com.demos.bnta.word_guesser.models.Player;
import com.demos.bnta.word_guesser.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerService(){

    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id){
        return playerRepository.findById(id);
    }

    public void createPlayer(String name){
        Player player = new Player(name);
        playerRepository.save(player);
    }

    public Player savePlayer(Player player){
        playerRepository.save(player);
        return player;
    }
}
