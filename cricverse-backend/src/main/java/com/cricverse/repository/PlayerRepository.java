package com.cricverse.repository;

import com.cricverse.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByNameContainingIgnoreCase(String name);

    List<Player> findByRoleIgnoreCase(String role);
    
}