package com.example.developers.controller;

import com.example.developers.model.Developer;
import com.example.developers.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class BasicController {

    @Autowired
    BasicService myService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String start(){
        return "Welcome to DevsCareer";
    }

//    GET method
    @RequestMapping(method = RequestMethod.GET, value = "/devs")
    public List<Developer> home(){
        return myService.getAllDevs();
    }

    @RequestMapping(method = RequestMethod.GET, value = "devs/exp/{experience}")
    public List<Developer> getSomeDevelopers(@PathVariable("experience") long exp){
        return myService.getSomeDevs(exp);
    }

    @RequestMapping(method = RequestMethod.GET, value = "devs/track/{track}")
    public List<Developer> getSomeDevelopers(@PathVariable("track") String track){
        return myService.getSomeDevs(track);
    }

    @RequestMapping(method = RequestMethod.GET, value = "devs/track/{track}/exp/{exp}")
    public List<Developer> getSomDevelopers(@PathVariable("track") String track, @PathVariable("exp") long exp){
        return myService.getSomeDevs(exp, track);
    }

    @RequestMapping(method = RequestMethod.GET, value = "devs/{firstName}_{lastName}")
    public List<Developer> getADeveloper(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return myService.getADev(firstName, lastName);
    }

//    POST method
    @RequestMapping(method = RequestMethod.POST, value = "devs")
    public List<Developer> postDeveloper(@RequestBody Developer dev){
        return myService.postADev(dev);
    }

//    DELETE method
    @RequestMapping(method = RequestMethod.DELETE, value = "devs/{firstName}_{lastName}")
    public void deleteDeveloper(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        myService.removeADev(firstName, lastName);
    }
}
