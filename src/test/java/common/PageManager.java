package common;

import driver.DriverFactory;
import pages.HomePage;
import pages.LoginPage;

public class PageManager {
    public LoginPage loginPage;
    public HomePage homePage;

    public PageManager(){
        DriverFactory.initDriver();

        loginPage = PageFactory.buildLoginPage();
        homePage = PageFactory.buildHomePage();
    }
}
