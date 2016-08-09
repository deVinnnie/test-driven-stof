package com.realdolmen.stof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StofController {

    @Autowired
    private StofRepository stofRepository;

    @RequestMapping(method= RequestMethod.POST, path="stof/create", consumes="application/son")
    public Stof createStof(@RequestBody /* @valid */ Stof stof){
        if(null != stof.getId()){
            throw new RuntimeException("New Stof should have ID");
        }
        if(!stof.isValid()){
            throw new IllegalArgumentException("Not valid!");
        }

        stofRepository.createStof(stof);

        return stof;
    }

    public Stof getStof(Long id){
        return stofRepository.getStof(id);
    }

}
