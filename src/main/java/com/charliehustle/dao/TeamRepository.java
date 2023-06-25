package com.charliehustle.dao;

import com.charliehustle.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    public Team findByEspnTeamId(String s);


}
