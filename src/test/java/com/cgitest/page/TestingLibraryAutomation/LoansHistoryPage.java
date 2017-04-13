package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Loans history' button located on OverviewPage screen.
 */

public class LoansHistoryPage extends AbstractPage{

    //  call constructor of AbstractPage class
    public LoansHistoryPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signLoansHistory = By.xpath("//div[contains(text(),'History of all loans')]");

    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getLoansHistoryText() {
        System.out.println("[step] getLoansHistoryText");
        return page.findElement(signLoansHistory).getText();
    }

    /**
     * Click on 'Overview' button.
     * @return New page.
     */
    public OverviewPage fromLoansHistoryToOverview() {
        System.out.println("[step] fromLoansHistoryToOverview");
        page.findElement(overviewBtn).click();
        return new OverviewPage(page);
    }
}
