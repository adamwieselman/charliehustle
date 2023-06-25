package com.charliehustle.models.json.espn;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class EspnAltSbDropdown {

    @JsonAlias("options")
    private List<EspnOption> espnOptions;

    @JsonAlias("label")
    private String label;

    @JsonAlias("type")
    private String type;

    public List<EspnOption> getEspnOptions() {
        return espnOptions;
    }

    public void setEspnOptions(List<EspnOption> espnOptions) {
        this.espnOptions = espnOptions;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
