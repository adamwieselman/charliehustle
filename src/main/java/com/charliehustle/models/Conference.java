package com.charliehustle.models;

import javax.persistence.*;

@Entity
@Table(name = "conference", schema = "basketball")
public class Conference {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "espnconferenceid")
    private String espnConferenceId;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspnConferenceId(){
        return espnConferenceId;
    }

    public void setEspnConferenceId(String espnConferenceId){
        this.espnConferenceId = espnConferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
