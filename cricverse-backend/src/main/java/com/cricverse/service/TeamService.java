package com.cricverse.service;

import org.springframework.stereotype.Service;

import com.cricverse.dto.CreateTeamRequest;
import com.cricverse.dto.TeamDTO;
import com.cricverse.entity.Team;
import com.cricverse.exception.ResourceNotFoundException;
import com.cricverse.repository.TeamRepository;

import java.util.List;

@Service
public class TeamService {
    
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private TeamDTO convertToDto(Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .country(team.getCountry())
                .coach(team.getCoach())
                .foundedYear(team.getFoundedYear())
                .build();
    }

    private Team convertToEntity(CreateTeamRequest request) {
        return Team.builder()
                .name(request.getName())
                .country(request.getCountry())
                .coach(request.getCoach())
                .foundedYear(request.getFoundedYear())
                .build();
    }

    public List<TeamDTO> getAllTeams() {

        List<Team> teams = teamRepository.findAll();

        return teams.stream()
                .map(this::convertToDto)
                .toList();
    }

    public TeamDTO getTeamById(Long id) {

        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found"));

        return convertToDto(team);
    }

    public TeamDTO createTeam(CreateTeamRequest request) {

        Team team = convertToEntity(request);

        Team savedTeam = teamRepository.save(team);

        return convertToDto(savedTeam);
    }

}
