package org.tw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewWallet extends BasePage {

    public CreateNewWallet(WebDriver driver) {super(driver);}

    @FindBy(xpath = "(//div[@class='flex items-center justify-between py-4 pl-3 pr-4'])[1]")
    private WebElement createNewWallet;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement newPasswordBox;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordBox;

    @FindBy(xpath = "//input[@data-testid='checkbox-terms-of-service']")
    private WebElement agreementCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(xpath = "//p[@class='title-text text-primary font-medium   text-unset']")
    private WebElement noThanksButton;

    @FindBy(xpath = "//div[@data-tooltip-id='button-tooltip-7']")
    private WebElement openWalletButton;

    @FindBy(xpath = "//div[@data-tooltip-id='button-tooltip-9']//button")
    private WebElement gotItButton;

    @FindBy(xpath = "//div[@data-tooltip-id='button-tooltip-24']//button")
    private WebElement readyToUseButton;

    @FindBy(xpath = "//div[@class='text-textBrand subtitle-text flex-1 text-start']")
    private WebElement BackUpBanner;





    public void clickCreateNewWallet() {
        createNewWallet.click();
    }
    public void setNewPasswordBox() {

        newPasswordBox.sendKeys("Twallet1234.");
        confirmPasswordBox.sendKeys("Twallet1234.");
    }

    public void clickAgreementBox() {
        agreementCheckBox.click();
    }
    public void clickNextButton() {
        nextButton.click();
    }
    public void clickNoThanksButton() {
        noThanksButton.click();
    }
    public void clickOpenNewWalletButton() {
        openWalletButton.click();
    }
    public void closeTipsPopup() {

        gotItButton.click();
        readyToUseButton.click();
    }

    //validating if user reached homepage
    public void validateHomePageUploaded() {

        if(BackUpBanner.isDisplayed()){
            System.out.println("The User successfully landed on HomePage");
        }
        else {
            System.out.println("The Wallet Creation is not Successful");
        }

    }



}
