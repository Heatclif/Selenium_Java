package automation.parabank.enums;

public enum MainMenuOptions {
    SOLUTIONS("Solutions"),
    ABOUT_US("About Us"),
    SERVICES("Services"),
    PRODUCTS("Products"),
    LOCATIONS("Locations"),
    ADMIN_PAGE("Admin Page");

    private final String menuName;

    MainMenuOptions(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }
}
