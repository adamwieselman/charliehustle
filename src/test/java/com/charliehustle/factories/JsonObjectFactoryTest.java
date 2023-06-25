package com.charliehustle.factories;

import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class JsonObjectFactoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public JsonObjectFactory jsonObjectFactory = new JsonObjectFactory();

    @Test
    public void testCreateJSONObject_successful() throws Exception {
        JSONObject jsonObject = jsonObjectFactory.createJSONObject("{}");
        assertTrue(jsonObject instanceof JSONObject);
    }

    @Test
    public void testCreateJSONObject_noBrackets_throwsException() throws Exception {
        try{
            JSONObject jsonObject = jsonObjectFactory.createJSONObject("badData");
            fail();
        }catch(Exception e){
            assertEquals("A JSONObject text must begin with '{' at 1 [character 2 line 1]", e.getMessage());
        }
    }

    @Test
    public void testCreateJSONObject_null_throwsException() throws Exception {
        try{
            JSONObject jsonObject = jsonObjectFactory.createJSONObject("badData");
            fail();
        }catch(Exception e){
            assertEquals("A JSONObject text must begin with '{' at 1 [character 2 line 1]", e.getMessage());
        }
    }

    @Test
    public void testCreateJSONObject_incompleteBracket_throwsException() throws Exception {
        try{
            JSONObject jsonObject = jsonObjectFactory.createJSONObject("{badData:bad");
            fail();
        }catch(Exception e){
            assertEquals("Expected a ',' or '}' at 13 [character 14 line 1]", e.getMessage());
        }
    }

}


