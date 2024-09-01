package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    public SelenideElement spnHompageTitle = $(".title");
    public SelenideElement btnAddCartSauceLabsBackpack = $("button[data-test=\"add-to-cart-sauce-labs-backpack\"]");
    public SelenideElement btnRemoveCartSauceLabsBackpack = $("button[data-test=\"remove-sauce-labs-backpack\"]");
    public SelenideElement listProductContainer = $(By.id("inventory_container"));

    public HomePage(String pageUrl) {
        super(pageUrl);
    }
    public void open_the_website() {
        open();
    }
    public void clickButton(String btnText){
        switch (btnText) {
            case "add to cart":
                btnAddCartSauceLabsBackpack.click();
                break;
            case "remove":
                btnRemoveCartSauceLabsBackpack.click();
                break;
            default:
                throw new Error("Button text not found");
        }
    }
}
