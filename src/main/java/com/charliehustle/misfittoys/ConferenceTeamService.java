package com.charliehustle.misfittoys;

import com.charliehustle.dao.ConferenceTeamRepository;
import com.charliehustle.models.Conference;
import com.charliehustle.models.ConferenceTeam;
import com.charliehustle.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceTeamService {

    @Autowired
    ConferenceTeamRepository conferenceTeamRepository;

    public List<ConferenceTeam> findByEspnConferenceIdAndEspnTeamIdOrderByStartDate(Conference conference, Team team){
        return conferenceTeamRepository.findByEspnConferenceIdAndEspnTeamIdOrderByStartDate(conference.getEspnConferenceId(), team.getEspnTeamId());
    }

    public List<ConferenceTeam> findByEspnTeamIdOrderByStartDate(Team team) {
        return conferenceTeamRepository.findByEspnTeamIdOrderByStartDate(team.getEspnTeamId());
    }

    public ConferenceTeam saveConferenceTeam(ConferenceTeam conferenceTeamObject) {
        return conferenceTeamRepository.saveAndFlush(conferenceTeamObject);
    }
}
