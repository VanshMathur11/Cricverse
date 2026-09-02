package com.cricverse.service;

import com.cricverse.dto.CreatePlayerRequest;
import com.cricverse.dto.PlayerDTO;
import com.cricverse.entity.Player;
import com.cricverse.exception.ResourceNotFoundException;
import com.cricverse.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    private PlayerDTO convertToDto(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .country(player.getCountry())
                .role(player.getRole())
                .build();
    }

    private Player convertToEntity(CreatePlayerRequest request) {
        return Player.builder()
            .name(request.getName())
            .country(request.getCountry())
            .role(request.getRole())
            .battingStyle(request.getBattingStyle())
            .bowlingStyle(request.getBowlingStyle())
            .build();
    }

    public List<PlayerDTO> getAllPlayers() {

        List<Player> players = playerRepository.findAll();

        return players.stream()
                .map(this::convertToDto)
                .toList();
    }

    public PlayerDTO getPlayerById(Long id) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        return convertToDto(player);
    }

    public PlayerDTO savePlayer(CreatePlayerRequest request) {

        Player player = convertToEntity(request);

        Player savedPlayer = playerRepository.save(player);

        return convertToDto(savedPlayer);
    }

    public List<PlayerDTO> searchPlayers(String name) {

        List<Player> players = playerRepository.findByNameContainingIgnoreCase(name);

        return players.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<PlayerDTO> searchPlayerByRole(String role) {
        
        List<Player> players = playerRepository.findByRoleIgnoreCase(role);

        return players.stream()
                .map(this::convertToDto)
                .toList();
    }
}