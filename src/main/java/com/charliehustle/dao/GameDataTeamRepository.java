package com.charliehustle.dao;

import com.charliehustle.models.GameDataTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataTeamRepository extends JpaRepository<GameDataTeam, Long> {
    public GameDataTeam findByEspnGameIdAndEspnTeamId(String espnGameId, String espnTeamId);
}

