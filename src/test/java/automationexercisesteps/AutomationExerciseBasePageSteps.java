package automationexercisesteps;

import automationexercise.AutomationExerciseBasePage;
import io.cucumber.java.en.Given;

public class AutomationExerciseBasePageSteps {

    private AutomationExerciseBasePage automationExerciseBasePage = new AutomationExerciseBasePage();
    
    @Given("I open the Automation Exercise home page")
    public void i_open_the_Automation_Exercise_home_page() {
        automationExerciseBasePage.openAutomationExerciseHomePage();
    }

    @Given("I open the {string} tab")
    public void i_open_the_tab(String tabName) {
        automationExerciseBasePage.openTab(tabName);
    }

    @Given("I debug")
    public void i_debug() {
        automationExerciseBasePage.debug();
    }
}
