package com.cgitest;

import com.cgitest.page.TestingLibraryAutomation.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * This is the main class representing common
 */

public class AppTest {

    // declaration
    WebDriver page;
    HomePage homePage;
    LoginPage loginPage;
    OverviewPage overviewPage;
    BooksPage booksPage;
    LoansPage loansPage;
    LoansHistoryPage loansHistoryPage;
    ReservationsPage reservationsPage;
    ChangePasswordPage changePasswordPage;
    SearchResultsPage searchResultsPage;
    LogoutPage logoutPage;

    // TEST DATA  [?] can be imported from file, database etc?
    private String myUsername = "p.homola";
    private String myPassword = "qJB5CuZrq";
    private String myNewPassword = "XJB5CuZrq";
    private String invalidPassword = "1";

    @BeforeClass
    public static void PrepareTestSet() throws InterruptedException {
        System.out.println("@BeforeClass - PrepareTestSet");
        //todo

    }

    @AfterClass
    public static void CleaningAfterTestSet() throws InterruptedException {
        System.out.println("@AfterClass - CleaningAfterTestSet");
        //todo
    }

    @Before
    public void PrepareTestCase() throws InterruptedException {
        System.out.println("@Before - PrepareTestCase");
        System.out.println("Opening Chrome");
        System.setProperty("webdriver.chrome.driver","C:\\dev\\selenium\\browserDrivers\\chromedriver.exe");
        page = new ChromeDriver();
        page.manage().window().maximize();
        // create browser instance
        homePage = new LoginPage(page).navigateToWebApp();
    }

    @After
    public void CleaningAfterTestCase() throws InterruptedException {
        System.out.println("@After - CleaningAfterTestCase");
        System.out.println("Closing Chrome");
        page.quit();
    }
// ============================== TEST CASES ===============================================
    /*
        TC01
    */
    @Test
    public void login() throws InterruptedException {
        System.out.println("[TC] login()");
        // [STEP] Open Homepage and click Log in button on lower right corner
        // [STEP] Fill in Email and password and click on Log in button right under password label
        // [STEP] Check Overview page was opened and welcome text appeared
        overviewPage = homePage
                .fromHomeToLogin()
                .enterCredentials(myUsername,myPassword)
                .confirmCredentials();
        // [VERIFY] Welcome text is shown
        Assert.assertTrue(overviewPage.getWelcomeText().contains("Welcome"));
    }

    /*
        TC02
    */
    @Test
    //@Ignore
    public void pages_clickable_and_able_to_open() throws InterruptedException {
        System.out.println("@Test - pages_clickable_and_able_to_open()");

        // [STEP] Login and go to Overview page
        // [STEP] Click on "Books" button and check books section is opened
        booksPage = homePage
                .fromHomeToLogin()
                .enterCredentials(myUsername,myPassword)
                .confirmCredentials()
                .fromOverviewToBooks();
        // [VERIFY] Books page opened and "Books - searching"  text is shown
        Assert.assertTrue(booksPage.getWelcomeText().contains("Books - searching"));
        // [STEP] Go back to Overview page
        // [STEP] Click on "Loans" button and check "Loans" section is opened
        loansPage = booksPage
                .fromBooksToOverview()
                .fromOverviewToLoans();
        // [VERIFY] "Loans" page opened and "Your loans"  text is shown
        Assert.assertTrue(loansPage.getLoansText().contains("Your loans"));
        // [STEP] Go back to Overview page
        // [STEP] Click on "Reservations" button and check "Reservation" section is opened
        reservationsPage = loansPage
                .fromLoansToOverview()
                .fromOverviewToReservations();
        // [VERIFY] "Reservations" page opened and "Your reservations"  text is shown
        Assert.assertTrue(reservationsPage.getReservationsText().contains("Your reservation"));
        // [STEP] Go back to Overview page
        // [STEP] Click on "Loans history" button and check "Loans history" section is opened
        loansHistoryPage = reservationsPage
                .fromReservationsToOverview()
                .fromOverviewToLoansHistory();
        // [VERIFY] "Loans history" page opened and "History of all loans"  text is shown
        Assert.assertTrue(loansHistoryPage.getLoansHistoryText().contains("History of all loans"));
        // [STEP] Go back to Overview page
        // [STEP] Click on "Change password" button and check "Change password" section is opened
        changePasswordPage = loansHistoryPage
                .fromLoansHistoryToOverview()
                .fromOverviewToChangePassword();
        // [VERIFY] "Change password" page opened and "Password change"  text is shown
        Assert.assertTrue(changePasswordPage.getChangePasswordText().contains("Password change"));
    }

    /*
    TC03
    */
    @Test
    public void search_in_authors() throws InterruptedException {
        System.out.println("@Test - search_in_authors()");
        // [STEP] Go to Homepage(not loged in)
        // [STEP] In search label insert "Cem", select search criteria "in authors" and click Search
        searchResultsPage = homePage
                .searchFor("Cem")
                .selectSearchBy("in authors")
                .submitSearching();
        // [VERIFY] Text "Authors - searching" was shown and 3 books were found for mentioned author in this version and data set of application
        WebElement resultTable = searchResultsPage.getResultTable();
            //create list of WebElements
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        Assert.assertTrue(tableRows.size() == 3);
        // [STEP] Check all authors have "cem" string in the name
            //iterate through all rows
        for(WebElement row : tableRows) {
            System.out.println("The whole row: " + row.getText());
            String cell = row.findElement(By.xpath("//td[1]")).getText();
            System.out.println("The first column value: " + cell);
            // [VERIFY] "cem" found in all listed Authors
            Assert.assertTrue(cell.toLowerCase().contains("cem"));
        }
    }

    /*
        TC04
    */
    @Test
    public void search_in_titles() throws InterruptedException {
        System.out.println("@Test - search_in_titles()");
        // [STEP] Login and go to Homepage
        // [STEP] In search label insert "test", select search criteria "in titles" and click Search
        searchResultsPage = homePage.searchFor("test").selectSearchBy("in titles").submitSearching();
        // [VERIFY] Text "Books - searching" was shown and 9 books listed with title containing Test in this version and data set of application
        WebElement resultTable = searchResultsPage.getResultTable();
        //create list of WebElements
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        Assert.assertTrue(tableRows.size() == 6);
        // [STEP] Check all titles have "test" string in the name
        //iterate through all rows
        for(WebElement row : tableRows) {
            System.out.println("The whole row: " + row.getText());
            String cell = row.findElement(By.xpath("//td[2]")).getText();
            System.out.println("The first column value: " + cell);
            // [VERIFY] "test" found in all listed titles
            Assert.assertTrue(cell.toLowerCase().contains("test"));
        }
    }


    /*
    TC05
    */
    @Test
    public void logout_of_user() throws InterruptedException {
        System.out.println("@Test - logout_of_user");
        // [STEP] Login and go to Overview page
        // [STEP] Click Log out in lower right section and check text on the next page
        logoutPage = homePage
                .fromHomeToLogin()
                .enterCredentials(myUsername,myPassword)
                .confirmCredentials()
                .logout();

        // [VERIFY] Text "Logout" and "You were successfully logged out." appeared
        Assert.assertTrue(logoutPage.getLogoutText().contains("You were successfully logged out."));

    }

    /*
    TC06
    */
    @Test
    public void change_password_for_user() throws InterruptedException {
        System.out.println("@Test - change_password_for_user()");
        // [STEP] Login and go to Overview page
        // [STEP] Click on "Change password" button and check "Change password" section is opened

        changePasswordPage = homePage
                .fromHomeToLogin()
                .enterCredentials(myUsername,myPassword)
                .confirmCredentials()
                .fromOverviewToChangePassword();
        // [VERIFY] "Change password" page opened and "Password change"  text is shown
        Assert.assertTrue(changePasswordPage.getChangePasswordText().contains("Password change"));


        // [STEP] Insert old password in Old password label and the new one in New password and Confirm password label meeting password criteria
        // [STEP] Click on change button to confirm password change
        changePasswordPage = changePasswordPage
                .enterNewCredentials(myPassword,myNewPassword)
                .confirmNewCredentials();
        // [VERIFY] Text "Password has been changed." appeared
        Assert.assertTrue(changePasswordPage.getChangePasswordConfText().contains("Password has been changed"));

        // [STEP] Log out from Testing library
        // [STEP] Try to log in with old password
        loginPage = changePasswordPage
                .logout()
                .fromLogoutToLogin()
                .enterCredentials(myUsername,myPassword)
                .confirmIncorrectCredentials();

        // [VERIFY] Login failed and text "Email address was not found in the system or you've entered incorrect password." appeared
        Assert.assertTrue(loginPage.getLoginFailedText().contains("Email address was not found in the system or you've entered incorrect password."));

        // [STEP]  Try to log in with new password
        overviewPage = loginPage
                .enterCredentials(myUsername,myNewPassword)
                .confirmCredentials();

        // [VERIFY] Login successful
        Assert.assertTrue(overviewPage.getWelcomeText().contains("Welcome"));
        // [CLEANUP] set the password back

        changePasswordPage = overviewPage
                .fromOverviewToChangePassword()
                .enterNewCredentials(myNewPassword,myPassword)
                .confirmNewCredentials();


    }


}
