package com.charliehustle.dao;

import com.charliehustle.models.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    public Conference findByEspnConferenceId(String espnConferenceId);
}
