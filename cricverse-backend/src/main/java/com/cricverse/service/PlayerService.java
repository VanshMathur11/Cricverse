package com.cricverse.service;

import com.cricverse.dto.PlayerDTO;
import com.cricverse.entity.Player;
import com.cricverse.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> getAllPlayers() {

        List<Player> players = playerRepository.findAll();

        return players.stream()
                .map(player -> PlayerDTO.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .country(player.getCountry())
                        .role(player.getRole())
                        .build())
                .toList();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}