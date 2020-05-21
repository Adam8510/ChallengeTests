package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PositiveMainPageFilterTests extends TestBase {

    @Test
    public void searchByNameTest() {

        MainPage mainPage = new MainPage();

        String name = "Alabaster";
        String actualName = mainPage.getTableElements().getText();
        mainPage.typeIntoSearchField(name);

        assertEquals(actualName, name);
    }

    @Test
    public void dropDownListingTest() {

        MainPage mainPage = new MainPage();

        Select searchMethods = new Select(mainPage.getSearchMethod());
        List<WebElement> options = searchMethods.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());

            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("Id");
        expectedNamesOfOptions.add("Name");
        expectedNamesOfOptions.add("Email");
        expectedNamesOfOptions.add("City");

        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
    public void checkClearFilterButton() {

        MainPage mainPage = new MainPage();

        String name = "Bondir";
        String actualTextInSearchFilter = mainPage.getSearchFieldText().getAttribute("placeholder");
        String expectedTextInSearchFilter = "Search";

        mainPage.typeIntoSearchField(name);
        mainPage.clearButtonClick();

        assertEquals(expectedTextInSearchFilter, actualTextInSearchFilter);
    }
}
