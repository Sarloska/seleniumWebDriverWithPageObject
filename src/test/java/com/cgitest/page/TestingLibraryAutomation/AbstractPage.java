
package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This is the main class representing common web page locators and functionality which can be inherited.
 */

public class AbstractPage {
    protected WebDriver page;

    // constructor
    public AbstractPage(WebDriver page){
        this.page = page;
    }

    // global locators
    protected By homePageBtn = By.linkText("Homepage");
    protected By overviewBtn = By.linkText("Overview");
    protected By loginBtn = By.linkText("Log in");
    protected By logoutBtn = By.linkText("Log out");

    /**
     * Navigates to the  web application under test.
     * @return New page.
     */
    public HomePage navigateToWebApp() {
        System.out.println("[step] navigateToWebApp");
        page.navigate().to("http://cz304544.groupinfra.com/auto-library/index.php");
        return new HomePage(page);
    }

    /**
     * The title of the current page.
     * @return The title of the current page, with leading and trailing whitespace stripped, or null if one is not already set
     */
    public String getPageTitle() {
        System.out.println("[step] getPageTitle");
        return page.getTitle();
    }


}
