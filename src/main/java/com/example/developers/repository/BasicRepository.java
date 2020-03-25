package com.example.developers.repository;

import com.example.developers.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BasicRepository extends CrudRepository<Developer, Long> {

    List<Developer> findByExperience(Long experience);
    List<Developer> findByTrack(String track);
    List<Developer> findByExperienceAndTrack(long experience, String track);
    List<Developer> findByFirstNameAndLastName(String firstName, String lastName);
}
