package com.realdolmen.stof;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StofWebTest {

    @Test
    public void testSel(){
        WebDriver driver  = new FirefoxDriver();
        driver.get("http://www.google.com");
    }


}
