package com.cricverse.controller;

import com.cricverse.dto.PlayerDTO;
import com.cricverse.entity.Player;
import com.cricverse.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @GetMapping("/search")
    public List<PlayerDTO> searchPlayer(@RequestParam String name) {
        return playerService.searchPlayers(name);
    }

    @GetMapping("/search/role")
    public List<PlayerDTO> searchPlayerByRole(@RequestParam String role) {
        return playerService.searchPlayerByRole(role);
    }
    
    
}