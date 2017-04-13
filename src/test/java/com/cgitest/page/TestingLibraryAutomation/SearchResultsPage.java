package com.cgitest.page.TestingLibraryAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the screen to which you are navigated after click on 'Search' button located on HomePage screen.
 */

public class SearchResultsPage extends AbstractPage{

    //  call constructor of AbstractPage class
    public SearchResultsPage(WebDriver page) {
        super(page);
    }

    // screen WebElements definition
    private By signSearch = By.xpath("//div[contains(text(),'searching ')]");
    private By resultTable = By.tagName("table");


    /**
     * Looking for the screen based title.
     * @return Screen title.
     */
    public String getSearchResultsText() {
        System.out.println("[step] getSearchResultsText");
        return page.findElement(signSearch).getText();
    }

    /**
     * Looking for search result table.
     * @return Whole table with results.
     */
    public WebElement getResultTable() {
        System.out.println("[step] getResultTable");
        return page.findElement(resultTable);
    }


}
