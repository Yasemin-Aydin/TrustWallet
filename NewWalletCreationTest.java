package org.tw.tests;

import org.testng.annotations.Test;
import org.tw.factory.PageInstancesFactory;
import org.tw.pages.CreateNewWallet;

public class NewWalletCreationTest extends BaseTest {

    @Test(description = "Sample description")
    public void newWalletCreationTest() {
        CreateNewWallet newWallet = PageInstancesFactory.getInstance(CreateNewWallet.class);

        newWallet.clickCreateNewWallet();
        newWallet.setNewPasswordBox();
        newWallet.clickAgreementBox();
        newWallet.clickNextButton();
        newWallet.clickNoThanksButton();
        newWallet.clickOpenNewWalletButton();
        newWallet.closeTipsPopup();
        newWallet.validateHomePageUploaded();

    }

}