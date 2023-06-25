package com.charliehustle.misfittoys;

import com.charliehustle.dao.TeamRepository;
import com.charliehustle.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team findByEspnTeamId(String espnTeamId) {
        return teamRepository.findByEspnTeamId(espnTeamId);
    }

    public Team saveTeam(Team teamObject) {
        return teamRepository.saveAndFlush(teamObject);
    }
}
