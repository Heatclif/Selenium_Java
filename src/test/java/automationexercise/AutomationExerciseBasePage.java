package automationexercise;

import core.Base;

public class AutomationExerciseBasePage extends Base {

    private String url = "https://www.automationexercise.com/";

    public String TAB_DYNAMIC_XPATH = "//a[contains(text(), '%s')]";

    public String AUTOMATION_EXERCISE_LOGO = "//img[@alt='Website for automation practice']";

    public void openAutomationExerciseHomePage() {
        navigateTo(url);
        waitForElementToExist(AUTOMATION_EXERCISE_LOGO, 10);
    }

    public void openTab(String tabName) {
        String tabXpath = String.format(TAB_DYNAMIC_XPATH, tabName);
        clickElement(tabXpath);
        waitForElementToHaveAttribute(tabXpath, "style", "color: orange;", 10);
    }
}
