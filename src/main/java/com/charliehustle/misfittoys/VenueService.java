package com.charliehustle.misfittoys;

import com.charliehustle.dao.VenueRepository;
import com.charliehustle.models.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    VenueRepository venueRepository;

    public Venue findByEspnVenueId(String espnVenueId) {

        return venueRepository.findByEspnVenueId(espnVenueId);
    }

    public Venue saveVenue(Venue venueObject) {
        return venueRepository.saveAndFlush(venueObject);
    }
}
