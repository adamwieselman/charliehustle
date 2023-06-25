package com.charliehustle.validators;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.constants.CharlieHustleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataUpdateRequestValidator implements CharlieHustleConstants {

    @Autowired
    List<RequestValidator> requestValidators;

    public void validate(RequestContext request) {

        for(RequestValidator requestValidator : requestValidators){
            if(requestValidator.supports(GENERAL)){
                requestValidator.validate(request);
            }
        }

        if(request.getRequestInfo().getDate() != null) {
            for (RequestValidator requestValidator : requestValidators) {
                if (requestValidator.supports(DATE)) {
                    requestValidator.validate(request);
                }
            }
        }else {
            if (request.getRequestInfo().getYear() != null) {
                for (RequestValidator requestValidator : requestValidators) {
                    if (requestValidator.supports(YEAR)) {
                        requestValidator.validate(request);
                    }
                }

                if (request.getRequestInfo().getWeek() != null) {
                    for (RequestValidator requestValidator : requestValidators) {
                        if (requestValidator.supports(WEEK)) {
                            requestValidator.validate(request);
                        }
                    }
                }
            }
        }
    }
}
