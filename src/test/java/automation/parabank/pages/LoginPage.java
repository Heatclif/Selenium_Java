package automation.parabank.pages;

public class LoginPage extends ParaBankBasePage {

    public final String DYNAMIC_NAMED_FIELD_INPUT = "//b[text()='%s:']/parent::td/following-sibling::td/input";
    public final String DYNAMIC_PARAGRAPH_TEXT = "//p[text()='%s']";
    public final String DYNAMIC_ERROR_TEXT = "//span[@class='error' and text() = '%s']";

    public final String USERNAME_INPUT = "//input[@name='username']";
    public final String PASSWORD_INPUT = "//input[@name='password']";
    public final String LOGIN_BUTTON = "//input[@value='Log In']";
    public final String FORGOT_LOGIN_INFO_LINK = "//a[text()='Forgot login info?']";
    public final String REGISTER_LINK = "//a[text()='Register']";
    public final String FIND_MY_LOGIN_INFO_BUTTON = "//input[@value='Find My Login Info']";
    public final String CUSTOMER_LOOKUP_HEADER = "//h1[text()='Customer Lookup']";
    public final String REGISTRATION_HEADER = "//h1[text()='Signing up is easy!']";
    public final String REGISTER_BUTTON = "//input[@value='Register']";

    public void login(
            String userName,
            String userPassword
    ) {
        setValue(USERNAME_INPUT, userName);
        setValue(PASSWORD_INPUT, userName);
        click(LOGIN_BUTTON);
    }

    public void forgotLoginInfo(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zipCode,
            String ssn
    ) {
        click(FORGOT_LOGIN_INFO_LINK);
        waitForElementToBeVisible(CUSTOMER_LOOKUP_HEADER, 20);

        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "First Name"), firstName);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Last Name"), lastName);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Address"), address);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "City"), city);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "State"), state);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Zip Code"), zipCode);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "SSN"), ssn);

        click(FIND_MY_LOGIN_INFO_BUTTON);
    }

    public void registerUser(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zipCode,
            String phone,
            String ssn,
            String userName,
            String password
    ) {
        click(REGISTER_LINK);
        waitForElementToBeVisible(REGISTRATION_HEADER, 20);

        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "First Name"), firstName);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Last Name"), lastName);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Address"), address);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "City"), city);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "State"), state);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Zip Code"), zipCode);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Phone #"), phone);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "SSN"), ssn);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Username"), userName);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Password"), password);
        setValue(String.format(DYNAMIC_NAMED_FIELD_INPUT, "Confirm"), password);

        click(REGISTER_BUTTON);
    }
}
