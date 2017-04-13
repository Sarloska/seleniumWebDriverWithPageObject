package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Represents the screen to which you are navigated after click on 'Homepage' button.
 */

public class HomePage extends AbstractPage {

    //  call constructor of AbstractPage class
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // screen WebElements definition
    private By searchBtn = By.xpath("//input[@class='button' and @value='Search']");
    private By searchBox = By.name("hledat");
    private By searchDropDown = By.name("kde");

    /**
     * Click on 'Log in' button.
     * @return New page.
     */
    public LoginPage fromHomeToLogin() {
        System.out.println("[step] fromHomeToLogin");
        page.findElement(loginBtn).click();
        return new LoginPage(page);
    }

    /**
     * Insert string keyword into searching text box.
     * @param what keyword to be found.
     * @return Current page.
     */
    public HomePage searchFor(String what) {
        System.out.println("[step] searchFor");
        page.findElement(searchBox).sendKeys(what);
        return this; //new HomePage(page);
    }

    /**
     * Click on 'Search' button.
     * @return New page.
     */
    public SearchResultsPage submitSearching() {
        System.out.println("[step] submitSearching");
        page.findElement(searchBtn).click();
        return new SearchResultsPage(page);
    }

    /**
     * Select item from dropDown.
     * @param dropDownValue Text of the dropdown item.
     * @return Current page.
     */
    public HomePage selectSearchBy(String dropDownValue) {
        System.out.println("[step] selectSearchBy");
        Select dropDown= new Select(page.findElement(searchDropDown));
        dropDown.selectByVisibleText(dropDownValue);
        return this;
    }

}
