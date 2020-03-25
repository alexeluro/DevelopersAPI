package com.example.developers.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Developer {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private int experience;
//    private List<String> languages;
    private String track;
    private float worth;


    public Developer() {
    }

    @Autowired
    public Developer(String firstName, String lastName, int experience, String track, float worth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
//        this.languages = languages;
        this.track = track;
        this.worth = worth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

//    public List<String> getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(List<String> languages) {
//        this.languages = languages;
//    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public float getWorth() {
        return worth;
    }

    public void setWorth(float worth) {
        this.worth = worth;
    }
}
