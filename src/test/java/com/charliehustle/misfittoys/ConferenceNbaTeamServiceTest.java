package com.charliehustle.misfittoys;

import com.charliehustle.dao.ConferenceTeamRepository;
import com.charliehustle.models.Conference;
import com.charliehustle.models.ConferenceTeam;
import com.charliehustle.models.GameData;
import com.charliehustle.models.Team;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConferenceNbaTeamServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    ConferenceTeamRepository conferenceTeamRepository;

    @InjectMocks
    public ConferenceTeamService conferenceTeamService = new ConferenceTeamService();

    @Test
    public void testFindByEspnTeamIdOrderByStartDate() {
        List<ConferenceTeam> conferenceTeams = new ArrayList<>();
        Conference conference = new Conference();
        GameData gameData = new GameData();
        LocalDateTime gameDateTime = LocalDateTime.now();
        gameData.setGameDateTime(gameDateTime);
        LocalDate gameDate = gameDateTime.toLocalDate();
        conference.setEspnConferenceId("145");
        Team team = new Team();
        team.setEspnTeamId("11");

        Mockito.when(conferenceTeamRepository.findByEspnTeamIdOrderByStartDate("11")).thenReturn(conferenceTeams);
        conferenceTeamService.findByEspnTeamIdOrderByStartDate(team);
        Mockito.verify(conferenceTeamRepository).findByEspnTeamIdOrderByStartDate("11");
    }

    @Test
    public void testFindByEspnConferenceIdAndEspnTeamIdOrderByStartDate() {
        List<ConferenceTeam> conferenceTeams = new ArrayList<>();
        Conference conference = new Conference();
        conference.setEspnConferenceId("11");
        Team team = new Team();
        team.setEspnTeamId("845");

        Mockito.when(conferenceTeamRepository.findByEspnConferenceIdAndEspnTeamIdOrderByStartDate("11", "845")).thenReturn(conferenceTeams);
        conferenceTeamService.findByEspnConferenceIdAndEspnTeamIdOrderByStartDate(conference, team);
        Mockito.verify(conferenceTeamRepository).findByEspnConferenceIdAndEspnTeamIdOrderByStartDate("11", "845");
    }

    @Test
    public void testSaveConferenceTeam() {
        ConferenceTeam conferenceTeam = new ConferenceTeam();
        Mockito.when(conferenceTeamRepository.saveAndFlush(conferenceTeam)).thenReturn(conferenceTeam);
        conferenceTeamService.saveConferenceTeam(conferenceTeam);
        Mockito.verify(conferenceTeamRepository).saveAndFlush(conferenceTeam);
    }
}
