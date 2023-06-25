package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Team;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class NbaTeamJsonHandlerHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public TeamJsonHandlerHelper teamJsonHandlerHelper = new TeamJsonHandlerHelper();

    @Test
    public void testCreateTeamObject_HappyPath(){
        String competitionString = "{\"date\": \"2018-11-10T00:00Z\",\"conferenceCompetition\": false,\"competitors\": [{\"team\": {\"alternateColor\": \"ffffff\"," +
                                   "\"venue\": {\"id\": \"251\"},\"color\": \"005DAA\",\"displayName\": \"Kentucky Wildcats\",\"abbreviation\": \"UK\",\"isActive\": true," +
                                   "\"shortDisplayName\": \"Kentucky\",\"uid\": \"s:40~l:41~t:96\",\"conferenceId\": \"23\",\"name\": \"Wildcats\"," +
                                   "\"logo\": \"https://a.espncdn.com/i/teamlogos/ncaa/500/96.png\",\"location\": \"Kentucky\",\"id\": \"96\"}," +
                                   "\"type\": \"team\",\"uid\": \"s:40~l:41~t:96\",\"homeAway\": \"home\",\"score\": \"71\",\"winner\": true,\"id\": \"96\"," +
                                   "\"linescores\": [{\"value\": 31},{\"value\": 40}]}]}";
        JSONObject competition = new JSONObject(competitionString);
        Mockito.when(basicObjectFactory.createTeam()).thenReturn(new Team());
        Team team = teamJsonHandlerHelper.createTeamObject(competition, 0);

        assertEquals("96", team.getEspnTeamId());
        assertEquals("Kentucky Wildcats", team.getName());
        assertEquals("Kentucky", team.getShortName());
    }



}
