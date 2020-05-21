package pages;

import common.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "#search-input")
    private WebElement searchField;

    @FindBy(css = "#search-column")
    private WebElement searchMethod;

    @FindBy(xpath="//tbody/tr/td[2]")
    private WebElement tableElements;

    @FindBy(xpath = "//span[@id='table-resume']")
    private WebElement messageLabel;

    @FindBy(id = "clear-button")
    private WebElement clearButton;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoSearchField(String value) {
        searchField.clear();
        searchField.sendKeys(value);
    }

//    public void selectSearchMethod(String typeSearchMethod) {
//        searchMethod.sendKeys(typeSearchMethod);
//    }

    public WebElement getSearchMethod() {
        return searchMethod;
    }

    public String selectedOptionMsg() {
        String optionMsg = messageLabel.getText();
        return optionMsg;
    }

    public WebElement getTableElements() {
        return tableElements;
    }

    public WebElement getSearchFieldText() {
        return searchField;
    }

    public void clearButtonClick() {
        clearButton.click();
    }
}
