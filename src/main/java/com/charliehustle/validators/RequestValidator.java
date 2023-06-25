package com.charliehustle.validators;

import com.charliehustle.beans.RequestContext;

public interface RequestValidator {

    boolean supports(String supportType);

    void validate(RequestContext requestContext);
}
