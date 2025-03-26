package automation.parabank.pages;

import automation.core.Base;
import automation.parabank.enums.MainMenuOptions;
import org.openqa.selenium.By;

public class ParaBankBasePage extends Base {

    public final String DYNAMIC_MAIN_PANEL_MENU_ITEM = "//div[@id='headerPanel']/ul[@class ='leftmenu']//a[text()='%s']";
    public final String DYNAMIC_PAGE_BUTTON = "//div[@id='headerPanel']/ul[@class ='button']/li[@class = '%s']";

    public final String PARA_BANK_LOGO = "//img[@title='ParaBank']";

    public void open() {
        navigateTo("https://parabank.parasoft.com/parabank/index.htm");
        waitForElementToBeVisible(PARA_BANK_LOGO, 20);
    }

    public void openFromDynamicMenu(
            MainMenuOptions options
    ) {
        getDriver().findElement(
                By.xpath(String.format(DYNAMIC_MAIN_PANEL_MENU_ITEM, options.getMenuName()))
        ).click();
    }

    public void goToHomePage() {
        getDriver().findElement(
                By.xpath(String.format(DYNAMIC_PAGE_BUTTON, "home"))
        ).click();
    }

    public void goToAboutUsPage() {
        getDriver().findElement(
                By.xpath(String.format(DYNAMIC_PAGE_BUTTON, "aboutus"))
        ).click();
    }

    public void goToContactUsPage() {
        getDriver().findElement(
                By.xpath(String.format(DYNAMIC_PAGE_BUTTON, "contact"))
        ).click();
    }
}
