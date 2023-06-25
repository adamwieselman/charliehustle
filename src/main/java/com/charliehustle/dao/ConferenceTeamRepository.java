package com.charliehustle.dao;

import com.charliehustle.models.ConferenceTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceTeamRepository extends JpaRepository<ConferenceTeam, Long> {
    public List<ConferenceTeam> findByEspnTeamIdOrderByStartDate(String espnTeamId);

    public List<ConferenceTeam> findByEspnConferenceIdAndEspnTeamIdOrderByStartDate(String espnConferenceId, String espnTeamId);

}

