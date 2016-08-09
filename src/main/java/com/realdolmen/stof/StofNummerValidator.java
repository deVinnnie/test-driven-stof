package com.realdolmen.stof;

import java.util.regex.Pattern;

public class StofNummerValidator {

    private static final Pattern PATTERN = Pattern.compile("STOF/([a-zA-Z0-9])/([a-zA-Z0-9])/([a-zA-Z0-9])");

    public boolean validateStofNummer(String stofNummer){
        if(stofNummer == null){
            return false;
        }
        return PATTERN.matcher(stofNummer).matches();
    }
}
