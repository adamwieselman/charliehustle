package com.charliehustle.misfittoys;

import com.charliehustle.dao.ConferenceRepository;
import com.charliehustle.models.Conference;
import org.springframework.beans.factory.annotation.Autowired;

public class ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    public Conference findByEspnConferenceId(String espnConferenceId) {
        return conferenceRepository.findByEspnConferenceId(espnConferenceId);
    }

    public Conference saveConference(Conference conferenceObject) {
        return conferenceRepository.saveAndFlush(conferenceObject);
    }
}
