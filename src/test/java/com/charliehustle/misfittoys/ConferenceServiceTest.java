package com.charliehustle.misfittoys;

import com.charliehustle.dao.ConferenceRepository;
import com.charliehustle.models.Conference;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ConferenceServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    ConferenceRepository conferenceRepository;

    @InjectMocks
    public ConferenceService conferenceService = new ConferenceService();

    @Test
    public void testFindByEspnConferenceId(){
        Conference conference = new Conference();
        Mockito.when(conferenceRepository.findByEspnConferenceId("23345")).thenReturn(conference);

        conferenceService.findByEspnConferenceId("23345");
        Mockito.verify(conferenceRepository).findByEspnConferenceId("23345");
    }

    @Test
    public void testSaveTest(){
        Conference conference = new Conference();
        Mockito.when(conferenceRepository.saveAndFlush(conference)).thenReturn(conference);

        conferenceService.saveConference(conference);
        Mockito.verify(conferenceRepository).saveAndFlush(conference);
    }


}
