package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Log in' button.
 */

public class LoginPage extends AbstractPage {

    //  call constructor of AbstractPage class
    public LoginPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By userName = By.name("email");
    private By password = By.name("heslo");
    private By loginBtn = By.xpath("//input[@type='submit' and @value='Log in']");
    private By signIncorrectCredentials = By.xpath("//div[contains(text(),'Email address was not found in the system or you')]");

    /**
     * Populates login form.
      * @param name Username.
     * @param pass Password.
     * @return Current page.
     */
    public LoginPage enterCredentials(String name,String pass) {
        System.out.println("[step] enterCredentials");
        page.findElement(userName).sendKeys(name);
        page.findElement(password).sendKeys(pass);
        return this;
    }

    /**
     * Click on 'Log in' button.  Precondition : CORRECT credentials has been populated before.
     * @return New page.
     */
    public OverviewPage confirmCredentials(){
        System.out.println("[step]confirmCredentials");
        page.findElement(loginBtn).click();
        return new OverviewPage(page);
    }

    /**
     * Click on 'Log in' button.   Precondition : INVALID credentials has been populated before.
     * @return Current page.
     */
    public LoginPage confirmIncorrectCredentials(){
        System.out.println("[step]confirmIncorrectCredentials");
        page.findElement(loginBtn).click();
        return this;
    }

    /**
     * Looking for the error message after failed attempt to log in.
     * @return Error message text.
     */
    public String getLoginFailedText() {
        System.out.println("[step] getLoginFailedText");
        return page.findElement(signIncorrectCredentials).getText();
    }

}
