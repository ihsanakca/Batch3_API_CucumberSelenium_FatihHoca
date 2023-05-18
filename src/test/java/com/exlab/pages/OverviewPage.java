package com.exlab.pages;


import com.exlab.utilities.ConfigurationReader;
import com.exlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//button[text()='Overview']")
    public WebElement overviewPageSubTitle;

    public String addedEducationName(String schoolName) {
        return Driver.get().findElement(By.xpath("//span[text()='" + schoolName + "']")).getText();
    }

    public String addedExperienceName(String jobTitle) {
        navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");
        return Driver.get().findElement(By.xpath("(//span[text()='" + jobTitle + "'])[1]")).getText();
    }

}
