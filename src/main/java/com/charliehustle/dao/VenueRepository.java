package com.charliehustle.dao;

import com.charliehustle.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    public Venue findByEspnVenueId(String s);
}
