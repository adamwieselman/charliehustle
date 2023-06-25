package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Conference;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class ConferenceJsonHandlerHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public ConferenceJsonHandlerHelper conferenceJsonHandlerHelper = new ConferenceJsonHandlerHelper();

    @Test
    public void testConferenceObject_HappyPath(){
        String conferenceString = "{\"type\": \"scoreboard\",\"content\": {\"league\": \"mens-college-basketball\",\"altSbDropdown\": {\"options\": [" +
                "{\"isSelected\": true,\"data\": {\"week\": \"null-null-null\",\"group\": \"50\"},\"label\": \"Division I\",\"value\": \"#\"}," +
                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"3\"},\"label\": \"A 10\",\"value\": \"#\"}," +
                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"2\"},\"label\": \"ACC\",\"value\": \"#\"}," +
                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"46\"},\"label\": \"ASUN\",\"value\": \"#\"}]}}}";
        JSONObject conferenceStringObject = new JSONObject(conferenceString);
        Mockito.when(basicObjectFactory.createConference()).thenReturn(new Conference());
        Conference conference = conferenceJsonHandlerHelper.createConferenceObject(conferenceStringObject, 3);

        assertEquals("46", conference.getEspnConferenceId());
        assertEquals("ASUN", conference.getName());
    }
}
