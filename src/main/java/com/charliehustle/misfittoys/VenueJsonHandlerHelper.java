package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Venue;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VenueJsonHandlerHelper {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public Venue generateVenueObject(JSONObject competition) {
        Venue venue = basicObjectFactory.createVenue();
        JSONObject venueObject = competition.getJSONObject("venue");
        JSONObject venueAddress = venueObject.getJSONObject("address");
        venue.setEspnVenueId(venueObject.getString("id"));
        venue.setFullName(venueObject.getString("fullName"));
        venue.setCity(venueAddress.getString("city"));
        venue.setState(venueAddress.getString("state"));
        return venue;
    }
}
