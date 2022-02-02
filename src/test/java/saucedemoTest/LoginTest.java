package saucedemoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.Page.LoginPage;

public class LoginTest extends BaseTest{
    public void openLoginPage(){
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

    }

    @BeforeMethod
    public void validCredentialsLoginTest() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    @Test
    public void usernamePlaceholderTest(){
        openLoginPage();
        Assert.assertEquals(loginPage.getUserNamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid");
        loginPage.getUserNamePlaceholder();
    }

    @Test
    public void lockedUserTest() {
        openLoginPage();
        loginPage.login(LOCKED_USER, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),
                loginPage.ERROR_MESSAGE_LOCKED,
                "Error message is incorrect");
    }

}
