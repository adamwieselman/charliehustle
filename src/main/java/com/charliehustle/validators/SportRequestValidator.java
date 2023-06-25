package com.charliehustle.validators;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.constants.CharlieHustleConstants;
import com.charliehustle.enums.GameSport;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SportRequestValidator implements RequestValidator, CharlieHustleConstants {

    @Override
    public boolean supports(String supportType) {
        if(supportType.equals(GENERAL)){
            return true;
        }
        return false;
    }

    @Override
    public void validate(RequestContext requestContext) {

        String sport = requestContext.getRequestInfo().getSport();
        List<String> errors = requestContext.getRequestInfo().getRequestErrors();

        if(StringUtils.trimToNull(sport) == null){
            errors.add("No sport is included in request");
        } else {

            boolean sportExists = false;
            for (GameSport gameSport : GameSport.values()) {
                if (sport.equals(gameSport.getSport())) {
                    sportExists = true;
                }
            }

            if (!sportExists) {
                errors.add("Sport entered does not match valid responses");
            }
        }

    }
}
