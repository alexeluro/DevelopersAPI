package com.example.developers.service;

import com.example.developers.model.Developer;
import com.example.developers.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class BasicService {

//    private List<Developer> devs = new ArrayList<>();
//    private List<String> lang = new ArrayList<>();

    @Autowired
    BasicRepository repository;

    public BasicService() {
    }

    public List<Developer> getAllDevs(){
        List<Developer> devs = new ArrayList<>();
        repository.findAll().forEach(devs::add);
        return devs;
    }

    public List<Developer> getSomeDevs(long experience) {
//        return devs.stream().filter(t->t.getExperience() >= experience).collect(Collectors.toList());
        return repository.findByExperience(experience);
    }

    public List<Developer> getSomeDevs(String track){
//        return devs.stream().filter(t -> t.getTrack().toLowerCase().contains(track.toLowerCase())).collect(Collectors.toList());
        return repository.findByTrack(track);
    }

    public List<Developer> getSomeDevs(long experience, String track){
//        return devs.stream().filter(t -> t.getTrack().toLowerCase().contains(track.toLowerCase()) && t.getExperience() >= experience)
//                .collect(Collectors.toList());
        return repository.findByExperienceAndTrack(experience, track);
    }

    public List<Developer> getADev(String firstName, String lastName){
//        return devs.stream().filter(t -> t.getFirstName().toLowerCase().equals(firstName.toLowerCase())
//        && t.getLastName().toLowerCase().equals(lastName.toLowerCase())).collect(Collectors.toList());
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Developer> postADev(Developer developer){
//        devs.add(developer);
        repository.save(developer);
        return getAllDevs();
    }

    public void removeADev(String firstName, String lastName){
//        devs.stream().filter(t -> t.getFirstName().toLowerCase().equals(firstName.toLowerCase()) &&
//                t.getLastName().toLowerCase().equals(lastName.toLowerCase())).forEach(t -> devs.remove(t));
        repository.findAll().forEach(new Consumer<Developer>() {
            @Override
            public void accept(Developer developer) {
                if (developer.getFirstName().equals(firstName) && developer.getLastName().equals(lastName)){
                    long id = developer.getId();
                    repository.deleteById(id);
                }
            }
        });
    }


}
