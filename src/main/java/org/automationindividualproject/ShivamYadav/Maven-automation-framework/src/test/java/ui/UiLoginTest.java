package ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;


@Listeners(listener.TestListener.class)
public class UiLoginTest extends BaseTest {

    @Test
    public void checkUsernameField(){

        /*CHECKING username input field is visible or not  */
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Username']")).isDisplayed());       

    }

    @Test
    public void checkPasswordField(){

         /*Checking password input is visible */
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Password']")).isDisplayed());

    }

    @Test
    public void checkLoginButton(){

        /*Checking Login button is Visible */
        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());

    }

    @Test
    public void checkLoginClickable(){

         /*Checking Login button is clickable  */
        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isEnabled());

    }
    
}
