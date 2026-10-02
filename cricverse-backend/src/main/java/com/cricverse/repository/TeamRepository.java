package com.cricverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricverse.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
