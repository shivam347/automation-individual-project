package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import dataprovider.LoginDataProvider;

/**
 * 
 * Each test runs with data from the provider and checks the expected result.
 */
@Listeners(listener.TestListener.class)
public class LoginTest extends BaseTest {

    /**
     * Perform login with the given username and password and check the result.
     * 
     * @param username       text to enter into username field
     * @param password       text to enter into password field
     * @param expectedResult 'success', 'error', or 'validation' - what we expect
     *                       after login
     */
    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password, String expectedResult) {

        // Enter username (clear the field first, then type the username)
        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

        // Enter password (clear the field first, then type the password)
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        // Click the login button to submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Check the result based on expectedResult value
        try {
            if (expectedResult.equals("success")) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlContains("dashboard"));

                Assert.assertTrue(
                        driver.getCurrentUrl().contains("dashboard"),
                        "Dashboard URL not loaded");

            } else if (expectedResult.equals("error")) {

                // On login error, an alert message should be visible
                Assert.assertTrue(
                        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
                                .isDisplayed());

            } else if (expectedResult.equals("validation")) {
                // On validation error, a field-level validation message should be visible
                Assert.assertTrue(driver.findElement(By.xpath(
                        "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"))
                        .isDisplayed());
            }

        } catch (TimeoutException e) {
            // If elements or page did not appear in time, fail the test with a clear
            // message
            Assert.fail("Expected result not achieved: " + expectedResult);
        }

    }
}
