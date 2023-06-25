package com.charliehustle.factories;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.directors.DataUpdateDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DirectorFactory {

    @Autowired
    private List<DataUpdateDirector> dataUpdateDirectors;

    public DataUpdateDirector returnDataUpdateDirector(RequestContext request)
    {
        for(DataUpdateDirector director : dataUpdateDirectors) {
            if(director.supports(request)){
                return director;
            }
        }

        request.getRequestInfo().getRequestErrors().add("No director match for sport requested");
        return null;
    }
}
