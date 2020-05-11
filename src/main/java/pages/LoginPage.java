package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends BasePage{
    private static By loginBtn = By.xpath("//a[text()='Login']");
    private static By email = By.id("email");
    private static By password = By.id("pass");
    private static By loginConfirmBtn = By.id("send2");
    private static By userName = By.xpath("//span[text()='william  jacob']");

public void navigateToLogin(){
    syscoLabUI.click(loginBtn);
}
public void enterEmail(String emailAddress){
    syscoLabUI.sendKeys(email,emailAddress);
}
public void enterPassword(String enterPassword){
    syscoLabUI.sendKeys(password,enterPassword);
}
public void clickLoginButton(){
    syscoLabUI.click(loginConfirmBtn);
}
public boolean isLoginButtonAvailable(){
    try {
        syscoLabUI.isDisplayed(loginBtn);
        return true;
    }catch (java.util.NoSuchElementException e){
        return false;
    }
}
public String getUserName() {
  return syscoLabUI.getText(userName);
}
}
