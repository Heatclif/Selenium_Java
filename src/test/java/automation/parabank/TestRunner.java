package automation.parabank;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features.parabank")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "summary")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "automation.parabank.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:, junit:target/cucumber-reports/Cucumber.xml, json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/Cucumber.html, timeline:target/cucumber-reports/CucumberTimeline")
@IncludeTags("Test")
public class TestRunner {
}