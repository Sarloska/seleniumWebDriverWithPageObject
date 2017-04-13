package com.cgitest.page.TestingLibraryAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the screen to which you are navigated after click on 'Books' button located on OverviewPage screen.
 */

public class BooksPage  extends AbstractPage{

    //  call constructor of AbstractPage class
    public BooksPage(WebDriver page) {super(page);}

    // Shared screen WebElements definition
    private By loansBtn = By.linkText("Loans");
    private By signBooks = By.xpath("//div[contains(text(),'Books - searching')]");

    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getWelcomeText() {
        System.out.println("[step] getWelcomeText");
        return page.findElement(signBooks).getText();
    }

    /**
     * Click on 'Overview' button.
     * @return New page.
     */
    public OverviewPage fromBooksToOverview() {
        System.out.println("[step] fromBooksToOverview");
        page.findElement(overviewBtn).click();
        return new OverviewPage(page);
    }

}
