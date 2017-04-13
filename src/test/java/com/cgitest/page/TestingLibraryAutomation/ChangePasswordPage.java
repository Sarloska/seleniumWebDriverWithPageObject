package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Change password' button located on OverviewPage screen.
 */

public class ChangePasswordPage extends AbstractPage{

    //  call constructor of AbstractPage class
    public ChangePasswordPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signChangePassword = By.xpath("//div[contains(text(),'Password change')]");
    private By signPasswordChanged = By.xpath("//div[contains(text(),'Password has been changed.')]");
    private By oldPassBox = By.name("passold");
    private By newPassBox = By.name("pass");
    private By newPassConfBox = By.name("pass2");
    private By changeBtn = By.xpath("//input[@type='submit' and @value='Change']");


    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String  getChangePasswordText() {
        System.out.println("[step] getChangePasswordText");
        return page.findElement(signChangePassword).getText();
    }

    /**
     * Looking for the confirmation text that password has been changed.
     * @return Confirmation text.
     */
    public String  getChangePasswordConfText() {
        System.out.println("[step] getChangePasswordConfText");
        return page.findElement(signPasswordChanged).getText();
    }

    /**
     * Populates change password form.
     * @param oldPass Current password.
     * @param newPass New password.
     * @return Current page.
     */
    public ChangePasswordPage enterNewCredentials(String oldPass,String newPass){
        System.out.println("[step] enterNewCredentials");
        page.findElement(oldPassBox).sendKeys(oldPass);
        page.findElement(newPassBox).sendKeys(newPass);
        page.findElement(newPassConfBox).sendKeys(newPass);
        return this;
    }

    /**
     *  Click on 'Change' button.
     * @return Current page..
     */
    public ChangePasswordPage confirmNewCredentials() {
        System.out.println("[step] confirmNewCredentials");
        page.findElement(changeBtn).click();
        return this;
    }

    /**
     * Click on 'Log out' button.
     * @return New page.
     */
    public LogoutPage logout() {
        System.out.println("[step] LogoutPage ");
        page.findElement(logoutBtn).click();
        return new LogoutPage(page);
    }
}
