package com.charliehustle.dao;

import com.charliehustle.models.TeamVenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamVenueRepository extends JpaRepository<TeamVenue, Long> {
    public TeamVenue findByEspnTeamIdAndEspnVenueId(String espnTeamId, String espnVenueId);
}

