package com.realdolmen.stof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public boolean deleteStof(@PathVariable Long stofId){
        Stof stof = stofRepository.getStof(stofId);
        stofRepository.deleteStof(stof);
        return true;
    }

    public Stof getStof(Long id){
        return stofRepository.getStof(id);
    }

}
