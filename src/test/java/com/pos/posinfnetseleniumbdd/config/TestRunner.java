package com.pos.posinfnetseleniumbdd.config;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/teste"
        , glue = { "com.pos.posinfnetseleniumbdd" }
        , strict = true
)
public class TestRunner {
}
