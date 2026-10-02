package com.cricverse.controller;

import com.cricverse.dto.CreateTeamRequest;
import com.cricverse.dto.TeamDTO;
import com.cricverse.service.TeamService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamRequest request) {
        return teamService.createTeam(request);
    }
}