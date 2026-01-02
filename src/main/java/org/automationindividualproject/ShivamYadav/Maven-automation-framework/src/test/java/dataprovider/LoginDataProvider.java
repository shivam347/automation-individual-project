package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
        return new Object[][]{
            {"Admin", "admin123", "success"},
            {"Admin", "Wrongpass", "error"},
            {"wrongAdmin", "admin123", "error"},
            {"wrongadmin", "wrongpass", "error"},
            {"", "admin123", "validation"},
            {"Admin", "", "validation"},
            {"","", "validation"}
        };
    }
}
