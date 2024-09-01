package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    public SelenideElement txtUsername = $("input[data-test=\"username\"]");
    public SelenideElement txtPassword = $("input[data-test=\"password\"]");
    public SelenideElement btnLogin = $("input[data-test=\"login-button\"]");
    public SelenideElement lblLoginError = $("h3[data-test=\"error\"]");

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }
    public void login(String username, String password) {
        txtUsername.setValue(username);
        txtPassword.setValue(password);
        btnLogin.click();
    }

    public String getLoginError(){
        return lblLoginError.getText();
    }
}
