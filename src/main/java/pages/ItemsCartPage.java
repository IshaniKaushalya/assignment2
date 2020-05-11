package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ItemsCartPage extends BasePage{
private static By cartStatus = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span");
private static By cart = By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']");
private static By closeItem = By.id("svg-icon-close");
private static By itemTypeWomen = By.id("mi-1-1");
private static By itemCategoryRun = By.id("mi-3-1-3-1");
private static By itemList = By.xpath("//*[@class='products list items product-items fix-mobile-view sli_container grid ']//li[@class='item product product-item sli_wrapper sli_col5']");
private String selectedItem = "product-item-info";
private String itemName = "product-item-link";
private String itemPrice = "price";
private static By sizeList = By.xpath("//*[@id='swatch-row-228']//div[@class='swatch-option text']");
private static By addToCartBtn = By.id("product-addtocart-button");
private String actualItemName = ("//h1[@class='page-title  product']//span");
private String actualPrice = ("//*[@class='product-info-price']//span/span/span");
private static By proceedToCheckoutBtn = By.xpath("//button[@title='Proceed To Checkout']");
private static By continueBtn = By.xpath("//button[@title='Continue']");
private By StreetAddressError = By.xpath("//*[@id='shipping-new-address-form']//div[@class='field _required _error']//div[@id='error-L8FMGXV']/span");
private By suburbError = By.xpath("//*[@id='error-RIFAF3E']/span[text()='This is a required field.']");
private By stateProvinceError = By.xpath("//*[@id='error-Y39XCQP']/span[text()='This is a required field.']");
private By postCodeError = By.xpath("//*[@id='error-CFU4A4Y']/span[text()='This is a required field.']");
private By phoneNumberError = By.xpath("//*[@id='error-XDRR5BH']/span[text()='This is a required field.']");
private static By scrollToCountry = By.xpath("//label/span[text()='Country']");
private static By postCode = By.xpath("//*[@class='control']//input[@name='postcode']");
private static By postCodeList = By.xpath("//*[@id='ui-id-1']//li");
private static By streetAddress = By.xpath("//*[@class='control']//input[@name='street[0]']");
private static By phoneNumber = By.xpath("//*[@class='control _with-tooltip']//input[@name='telephone']");
private static By creditCard = By.xpath("//*[@class='card-title'][text()='Credit Card']");
private static By placeOrderBtn = By.xpath("//*[@class='opc-submit-step']//button[@title='Place Order']");
private By emptyCreditCardError = By.xpath("//*[@class='hosted-error']/span");
private static By creditCartNumber = By.xpath("//*[@class='control']//div[@id='braintree_cc_number']");
private static By iframeCard = By.id("braintree-hosted-field-number");
private By emptyExpireDate = By.xpath("//*[@class='field date']//div/span");
private static By scrollToExpireDate = By.xpath("//*[@class='field date']//div");

public String getItemName;
public String getItemPrice;

public boolean checkCartStatusEmpty(){
 return !findElements(cartStatus,5l).isEmpty();
}
public void clickCart(){
 syscoLabUI.click(cart);
}

public void removeItemsFromCart(){
 if (!checkCartStatusEmpty()){
  syscoLabUI.click(cart);
 }
}
public void clickItemType(){
 syscoLabUI.click(itemTypeWomen);
}
public void navigateToCategory(){
 clickItemType();
 syscoLabUI.click(itemCategoryRun);
}
public void selectRandomItem(){
 List<WebElement> elements = syscoLabUI.findElements(itemList);
 Random random = new Random();
 int int_random = random.nextInt(elements.size());
 getItemName = syscoLabUI.getText(elements.get(int_random).findElement(By.className(itemName)));
 getItemPrice = syscoLabUI.getText(elements.get(int_random).findElement(By.className(itemPrice)));
 syscoLabUI.click(elements.get(int_random).findElement(By.className(selectedItem)));
}
public void selectSize(){
 List<WebElement> elements = syscoLabUI.findElements(sizeList);
 syscoLabUI.click(elements.get(0));
}
public void addToCartButton(){
 syscoLabUI.click(addToCartBtn);
}
public boolean isItemNameAvailable(){
 return syscoLabUI.getText(By.xpath(actualItemName)).equalsIgnoreCase(getItemName);
}
public boolean isItemPriceAvailable(){
 return syscoLabUI.getText(By.xpath(actualPrice)).equalsIgnoreCase(getItemPrice);
}
public void proceedToCheckOutButton(){
 syscoLabUI.scrollToElement(proceedToCheckoutBtn);
 syscoLabUI.click(proceedToCheckoutBtn);
}
public void continueButton(){
 syscoLabUI.scrollToElement(continueBtn);
 syscoLabUI.click(continueBtn);
 syscoLabUI.sleep(3);
}
public String getEmptyStreetAddressError(){
// syscoLabUI.scrollToElement(StreetAddressError);
// syscoLabUI.click(StreetAddressError);
 return syscoLabUI.getText(StreetAddressError);
}
 public String getSuburbError(){
  syscoLabUI.scrollToElement(suburbError);
  return syscoLabUI.getText(suburbError);
 }
 public String getStateProvinceError(){
  syscoLabUI.scrollToElement(stateProvinceError);
  return syscoLabUI.getText(stateProvinceError);
 }
 public String getPostCodeError(){
  syscoLabUI.scrollToElement(postCodeError);
  return syscoLabUI.getText(postCodeError);
 }
 public String getPhoneNumberError(){
  syscoLabUI.scrollToElement(phoneNumberError);
  return syscoLabUI.getText(phoneNumberError);
 }
public void enterPostCode(String PostCode){
 syscoLabUI.scrollToElement(scrollToCountry);
 syscoLabUI.sendKeys(postCode,PostCode);
}
 public void selectPostCode(){
  List<WebElement> elements = syscoLabUI.findElements(postCodeList);
  syscoLabUI.click(elements.get(0));
  syscoLabUI.sleep(3);
 }
 public void enterStreetAddress(String StreetAddress){
 syscoLabUI.sendKeys(streetAddress,StreetAddress);
 }
 public void enterPhoneNumber(String PhoneNumber){
  syscoLabUI.sendKeys(phoneNumber,PhoneNumber);
 }
 public void clickCreditCard(){
 syscoLabUI.click(creditCard);
 }
 public void clickPlaceOrder(){
  syscoLabUI.scrollToElement(placeOrderBtn);
  syscoLabUI.click(placeOrderBtn);
  syscoLabUI.sleep(3);
 }
 public String getEmptyCreditCardError(){
 return syscoLabUI.getText(emptyCreditCardError);
 }
public void enterCardNumber(String CardNumber){
 syscoLabUI.scrollToElement(scrollToExpireDate);
 syscoLabUI.click(creditCartNumber);
 syscoLabUI.switchToFrame(iframeCard);
}
 public String getEmptyExpirationError(){
  return syscoLabUI.getText(emptyExpireDate);
 }
}
