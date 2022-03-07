package com.cgg.task2;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"./Features/login.feature","./Features/postMethod.feature" })
public class TestRunner {

}
