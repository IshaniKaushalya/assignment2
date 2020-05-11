package functions;

import pages.ItemsCartPage;

public class ItemCart {
    private static ItemsCartPage itemsCartPage = new ItemsCartPage();

    public static void checkCartStatus(){
        itemsCartPage.removeItemsFromCart();
    }
    public static void navigateToCategory(){
        itemsCartPage.navigateToCategory();
    }
    public static void selectRandomItem(){
        itemsCartPage.selectRandomItem();
    }
    public static void selectSize(){
        itemsCartPage.selectSize();
    }
    public static void clickAddToCart(){
        itemsCartPage.addToCartButton();
    }
    public static boolean isItemNameAvailable(){
        return itemsCartPage.isItemNameAvailable();
    }
    public static boolean isItemPriceAvailable(){
        return itemsCartPage.isItemPriceAvailable();
    }
    public static void clickCart(){
        itemsCartPage.clickCart();
    }
    public static void clickProceedToCheckOut(){
        itemsCartPage.proceedToCheckOutButton();
    }
    public static void clickContinue(){
        itemsCartPage.continueButton();
    }
    public static String getStreetAddressError(){
        return itemsCartPage.getEmptyStreetAddressError();
    }
    public static String getSuburbsError(){
        return itemsCartPage.getSuburbError();
    }
    public static String getStateProvinceError(){
        return itemsCartPage.getStateProvinceError();
    }
    public static String getPostCodeError(){
        return itemsCartPage.getPostCodeError();
    }
    public static String getPhoneNumberError(){
        return itemsCartPage.getPhoneNumberError();
    }
    public static void enterPostCode(String PostCode){
        itemsCartPage.enterPostCode(PostCode);
    }
    public static void selectPostCode(){
        itemsCartPage.selectPostCode();
    }
    public static void enterStreetAddress(String StreetAddress){
        itemsCartPage.enterStreetAddress(StreetAddress);
    }
    public static void enterPhoneNumber(String PhoneNumber){
        itemsCartPage.enterPhoneNumber(PhoneNumber);
    }
    public static void clickCreditCard(){
        itemsCartPage.clickCreditCard();
    }
    public static void clickPlaceOrder(){
        itemsCartPage.clickPlaceOrder();
    }
    public static String getEmptyCreditCardError(){
        return itemsCartPage.getEmptyCreditCardError();
    }
    public static void enterCardNumber(String CardNumber){
        itemsCartPage.enterCardNumber(CardNumber);
    }
    public static String getEmptyExpirationError(){
        return itemsCartPage.getEmptyExpirationError();
    }
}
