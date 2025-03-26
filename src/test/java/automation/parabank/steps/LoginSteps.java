package automation.parabank.steps;

import automation.parabank.pages.LoginPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.Date;
import java.util.Map;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    @Given("User Opens Para Bank Login Page")
    public void open_para_bank_login_page() {
        loginPage.open();
    }

    @Given("User Registers an Account with the following data")
    public void registers_an_account_with_the_following_data(DataTable accountData) {
        Map<String, String> dataMap = accountData.asMap();
        loginPage.registerUser(
                dataMap.getOrDefault("First Name", ""),
                dataMap.getOrDefault("Last Name", ""),
                dataMap.getOrDefault("Address", ""),
                dataMap.getOrDefault("City", ""),
                dataMap.getOrDefault("State", ""),
                dataMap.getOrDefault("Zip Code", ""),
                dataMap.getOrDefault("Phone", ""),
                dataMap.getOrDefault("SSN", ""),
                dataMap.getOrDefault("Username", "") + String.valueOf(new Date().getTime()).substring(5),
                dataMap.getOrDefault("Password", "")
        );
    }

    @Given("User Sees the Message {string}")
    public void sees_the_message(String message) {
        loginPage.waitForElementToBeVisible(
                String.format(loginPage.DYNAMIC_PARAGRAPH_TEXT, message), 5);
    }

    @Given("User Sees the Error Message {string}")
    public void sees_the_error_message(String message) {
        loginPage.waitForElementToBeVisible(
                String.format(loginPage.DYNAMIC_ERROR_TEXT, message), 5);
    }
}
