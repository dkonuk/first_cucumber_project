package common;

import pages.HomePage;
import pages.LoginPage;

public class PageFactory {

    public static LoginPage buildLoginPage(){
        return new LoginPage("/");
    }

    public static HomePage buildHomePage(){
        return new HomePage("/inventory.html");
    }
}
