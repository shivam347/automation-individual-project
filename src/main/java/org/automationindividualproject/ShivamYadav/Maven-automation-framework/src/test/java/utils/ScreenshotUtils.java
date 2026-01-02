package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class ScreenshotUtils extends BaseTest {

    public static void takeScreenshot(String testname){
        try {

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());
            FileUtils.copyFile(src, new File("./screenshots/"+ testname + "_" + timeStamp + ".png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
