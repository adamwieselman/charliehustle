package com.charliehustle.validators;

import com.charliehustle.beans.RequestContext;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

public class DataUpdateRequestValidatorTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public DataUpdateRequestValidator dateValidator = new DataUpdateRequestValidator();

    @Mock
    RequestValidator requestValidator;

    @Test
    public void testValidate_OnlyGeneral(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setDate("dateValue");
        List<RequestValidator> requests = new ArrayList<>();
        requests.add(requestValidator);
        dateValidator.requestValidators = requests;

        Mockito.when(requestValidator.supports("general")).thenReturn(true);
        Mockito.doNothing().when(requestValidator).validate(request);

        dateValidator.validate(request);
    }

    @Test
    public void testValidate_GeneralAndDate(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setDate("dateValue");
        List<RequestValidator> requests = new ArrayList<>();
        requests.add(requestValidator);
        dateValidator.requestValidators = requests;

        Mockito.when(requestValidator.supports("general")).thenReturn(true);
        Mockito.when(requestValidator.supports("date")).thenReturn(true);
        Mockito.doNothing().when(requestValidator).validate(request);

        dateValidator.validate(request);
    }

    @Test
    public void testValidate_GeneralAndYear(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setYear("yearValue");
        List<RequestValidator> requests = new ArrayList<>();
        requests.add(requestValidator);
        dateValidator.requestValidators = requests;

        Mockito.when(requestValidator.supports("general")).thenReturn(true);
        Mockito.when(requestValidator.supports("year")).thenReturn(true);
        Mockito.doNothing().when(requestValidator).validate(request);

        dateValidator.validate(request);
    }

    @Test
    public void testValidate_GeneralAndYearAndWeek(){
        RequestContext request = new RequestContext();
        request.getRequestInfo().setYear("yearValue");
        request.getRequestInfo().setWeek("weekValue");
        List<RequestValidator> requests = new ArrayList<>();
        requests.add(requestValidator);
        dateValidator.requestValidators = requests;

        Mockito.when(requestValidator.supports("general")).thenReturn(true);
        Mockito.when(requestValidator.supports("year")).thenReturn(true);
        Mockito.when(requestValidator.supports("week")).thenReturn(true);
        Mockito.doNothing().when(requestValidator).validate(request);

        dateValidator.validate(request);
    }

//    public class DateValidator {
//        public LocalDate validateGameDate(String gameDate) throws Exception {
//            if (gameDate == null) {
//                throw new Exception("Date is null");
//            }
//
//            if(gameDate.length() != 8){
//                throw new Exception("There must be 8 characters in the gamedate");
//            }
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//            formatter = formatter.withLocale(Locale.US);
//            LocalDate date = LocalDate.parse(gameDate, formatter);
//
//            if(date.isAfter(LocalDate.now())){
//                throw new Exception("Date is too far in the future");
//            }
//
//            return date;
//        }
//    }
}