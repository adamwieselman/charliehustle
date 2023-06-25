package com.charliehustle.misfittoys;

import com.charliehustle.dao.VenueRepository;
import com.charliehustle.models.Venue;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class NbaWnbaVenueServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    VenueRepository venueRepository;

    @InjectMocks
    public VenueService venueService = new VenueService();

    @Test
    public void testFindByEspnVenueId(){
        Venue venue = new Venue();
        Mockito.when(venueRepository.findByEspnVenueId("23345")).thenReturn(venue);

        venueService.findByEspnVenueId("23345");
        Mockito.verify(venueRepository).findByEspnVenueId("23345");
    }

    @Test
    public void testSaveVenue(){
        Venue venue = new Venue();
        Mockito.when(venueRepository.saveAndFlush(venue)).thenReturn(venue);

        venueService.saveVenue(venue);
        Mockito.verify(venueRepository).saveAndFlush(venue);
    }
}
