package com.charliehustle.misfittoys;

import com.charliehustle.dao.TeamRepository;
import com.charliehustle.models.Team;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class NbaTeamServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    TeamRepository teamRepository;

    @InjectMocks
    public TeamService teamService = new TeamService();

    @Test
    public void testFindByEspnTeamId(){
        Team team = new Team();
        Mockito.when(teamRepository.findByEspnTeamId("23345")).thenReturn(team);

        teamService.findByEspnTeamId("23345");
        Mockito.verify(teamRepository).findByEspnTeamId("23345");
    }

    @Test
    public void testSaveTest(){
        Team team = new Team();
        Mockito.when(teamRepository.saveAndFlush(team)).thenReturn(team);

        teamService.saveTeam(team);
        Mockito.verify(teamRepository).saveAndFlush(team);

    }


}
