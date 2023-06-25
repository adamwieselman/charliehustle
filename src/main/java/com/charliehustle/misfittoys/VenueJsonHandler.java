package com.charliehustle.misfittoys;

import com.charliehustle.models.Venue;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class VenueJsonHandler {

    @Autowired
    VenueService venueService;

    @Autowired
    VenueJsonHandlerHelper venueJsonHandlerHelper;

    public Venue processVenueInfo(JSONObject competition) {
        Venue venue = venueService.findByEspnVenueId(competition.getJSONObject("venue").getString("id"));
        if(venue == null){
            venue = venueService.saveVenue(venueJsonHandlerHelper.generateVenueObject(competition));
        }
        return venue;
    }
}
