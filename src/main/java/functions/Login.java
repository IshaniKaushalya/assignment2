package functions;

import pages.LoginPage;

public class Login {

    private static LoginPage loginPage = new LoginPage();

    public static void navigateToLogin(){
        loginPage.navigateToLogin();
    }
    public static void enterEmail(String emailAddress){
        loginPage.enterEmail(emailAddress);
    }
    public static void enterPassword(String enterPassword){
        loginPage.enterPassword(enterPassword);
    }
    public static void clickLoginButton(){
        loginPage.clickLoginButton();
    }
    public boolean isLoginButtonAvailable(){
      return loginPage.isLoginButtonAvailable();
    }
    public String getUserName(){
        return loginPage.getUserName();
    }

}
