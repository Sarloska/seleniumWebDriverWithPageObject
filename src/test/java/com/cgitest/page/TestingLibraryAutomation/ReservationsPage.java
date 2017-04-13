package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Reservations' button located on OverviewPage screen.
 */

public class ReservationsPage extends AbstractPage{

    //  call constructor of AbstractPage class
    public ReservationsPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signReservations = By.xpath("//div[contains(text(),'Your reservations')]");


    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getReservationsText() {
        System.out.println("[step] getReservationsText");
        return page.findElement(signReservations).getText();
    }

    /**
     * Click on 'Overview' button.
     * @return New page.
     */
    public OverviewPage fromReservationsToOverview() {
        System.out.println("[step] fromReservationsToOverview");
        page.findElement(overviewBtn).click();
        return new OverviewPage(page);
    }


}
