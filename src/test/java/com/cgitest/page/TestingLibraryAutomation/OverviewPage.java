package com.cgitest.page.TestingLibraryAutomation;

import com.cgitest.page.TestingLibraryAutomation.BooksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Represents the screen to which you are navigated after click on 'Overview' button or after successful user's login.
 */

public class OverviewPage extends AbstractPage {

    //  call constructor of AbstractPage class
    public OverviewPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By booksBtn = By.linkText("Books");
    private By loansHistoryBtn = By.linkText("Loans history");
    private By loansBtn = By.linkText("Loans");
    private By changePasswordBtn = By.linkText("Change password");
    private By reservationsBtn = By.linkText("Reservations");
    private By signWelcome = By.xpath("//td[contains(text(),'Welcome')]");
    //

    /**
     * Click on 'Homepage' button.
     * @return New page.
     */
    public HomePage goFromOverviewPageToHomePage() {
        System.out.println("[step] goFromOverviewPageToHomePage");
        page.findElement(homePageBtn).click();
        return new HomePage(page);
    }

    /**
     * Looking for welcome text after successful login.
     * @return Welocme text.
     */
    public String getWelcomeText() {
        System.out.println("[step] getWelcomeText");
        return page.findElement(signWelcome).getText();
    }

    /**
     * Click on 'Books' button.
     * @return New page.
     */
    public BooksPage fromOverviewToBooks() {
        System.out.println("[step] fromOverviewToBooks ");
        page.findElement(booksBtn).click();
        return new BooksPage(page);
    }

    /**
     * Click on 'Loans' button.
     * @return New page.
     */
    public LoansPage fromOverviewToLoans() {
        System.out.println("[step] fromOverviewToLoans");
        page.findElement(loansBtn).click();
        return new LoansPage(page);
    }

    /**
     * Click on 'Loans history' button.
     * @return New page.
     */
    public LoansHistoryPage fromOverviewToLoansHistory() {
        System.out.println("[step] fromOverviewToLoansHistory");
        page.findElement(loansHistoryBtn).click();
        return new LoansHistoryPage(page);
    }

    /**
     * Click on 'Reservations' button.
     * @return New page.
     */
    public ReservationsPage fromOverviewToReservations() {
        System.out.println("[step] fromOverviewToReservations ");
        page.findElement(reservationsBtn).click();
        return new ReservationsPage(page);
    }

    /**
     * Click on 'Change password' button.
     * @return New page.
     */
    public ChangePasswordPage fromOverviewToChangePassword() {
        System.out.println("[step] fromOverviewToChangePassword ");
        page.findElement(changePasswordBtn).click();
        return new ChangePasswordPage(page);
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
