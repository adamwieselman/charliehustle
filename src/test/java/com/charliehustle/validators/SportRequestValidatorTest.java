package com.charliehustle.validators;

import com.charliehustle.beans.RequestContext;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SportRequestValidatorTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public SportRequestValidator sportRequestValidator = new SportRequestValidator();

    @Test
    public void testValidate_supports_true(){
        assertTrue(sportRequestValidator.supports("general"));
    }


    @Test
    public void testValidate_supports_false(){
        assertFalse(sportRequestValidator.supports("blah"));
    }


    @Test
    public void testValidate_sportFieldIsNull_addError(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setSport(null);

        sportRequestValidator.validate(request);
        assertTrue(request.hasRequestErrors());
    }

    @Test
    public void testValidate_sportFieldIsNotLegitSport_addError(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setSport("badmitton");

        sportRequestValidator.validate(request);
        assertTrue(request.hasRequestErrors());

    }

    @Test
    public void testValidate_sportFieldIsLegitSport_noError(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setSport("nba");

        sportRequestValidator.validate(request);
        assertFalse(request.hasRequestErrors());
    }


}