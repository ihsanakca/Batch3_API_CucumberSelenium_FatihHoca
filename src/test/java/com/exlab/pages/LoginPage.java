package com.exlab.pages;


import com.exlab.request.ExlabRequest;
import com.exlab.utilities.BrowserUtils;
import com.exlab.utilities.ConfigurationReader;
import com.exlab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "yourPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;


    public void loginMtd(){
        String userEmail= ConfigurationReader.get("userEmail");
        String password=ConfigurationReader.get("password");

        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }

    public void loginWithCredentialsMtd(String userEmail,String password){
        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
    }

    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
//        loginWithCredentialsMtd(ExlabRequest.email,ConfigurationReader.get("password"));
        loginWithCredentialsMtd(ConfigurationReader.get("userEmail"),ConfigurationReader.get("password"));
        BrowserUtils.waitFor(2);
    }

}
