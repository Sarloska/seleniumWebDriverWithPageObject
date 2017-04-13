package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Log out' button.
 */

public class LogoutPage extends AbstractPage {

    //  call constructor of AbstractPage class
    public LogoutPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signLogout = By.xpath("//div[contains(text(),'You were successfully logged out.')]");

    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getLogoutText() {
        System.out.println("[step] getLogoutText");
        return page.findElement(signLogout).getText();
    }

    /**
     * Click on 'Log in' page.
     * @return New page.
     */
    public LoginPage fromLogoutToLogin() {
        System.out.println("[step] fromLogoutToLogin ");
        page.findElement(loginBtn).click();
        return new LoginPage(page);
    }


}
