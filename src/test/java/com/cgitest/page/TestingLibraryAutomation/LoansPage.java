package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Loans' button located on OverviewPage screen.
 */

public class LoansPage extends AbstractPage{

    //  call constructor of AbstractPage class
    public LoansPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signLoans = By.xpath("//div[contains(text(),'Your loans')]");

    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getLoansText() {
        System.out.println("[step] getLoansText");
        return page.findElement(signLoans).getText();
    }

    /**
     * Click on 'Overview' button.
     * @return New page.
     */
    public OverviewPage fromLoansToOverview() {
        System.out.println("[step] fromLoansToOverview");
        page.findElement(overviewBtn).click();
        return new OverviewPage(page);
    }
}
