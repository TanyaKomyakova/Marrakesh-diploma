package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchasePage {
    private SelenideElement heading = $(".App_appContainer__3jRx1");
    private ElementsCollection buyButton = $$(".button__content");
    private ElementsCollection buyInCreditButton = $$(".button__content");
    private ElementsCollection cardField = $$(".input__control");
    private ElementsCollection enterMonth = $$(".input__control");
    private ElementsCollection enterYear = $$(".input__control");
    private ElementsCollection enterOwner = $$(".input__control");
    private ElementsCollection enterACode = $$(".input__control");
    private ElementsCollection continueButton = $$(".button__content");
    private ElementsCollection operationMessage = $$(".notification");
    private ElementsCollection dataError = $$(".input__sub");
    private ElementsCollection nameError = $$(".input__sub");
    private ElementsCollection monthFormatErrorMessage = $$(".input__sub");

    public PurchasePage() {
        heading.shouldBe(Condition.visible);
    }

    public PurchasePage approvedPurchase(DataHelper.CardInfo info) {
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public void getAMessageAboutSuccessfulOperation() {
        operationMessage.get(0).waitUntil(visible, 15000).shouldHave(text(" Успешно Операция одобрена Банком."));
    }

    public PurchasePage declinedPurchase(DataHelper.CardInfo info) {
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getInvalidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public void getAMessageAboutDeclinedOperation() {
        operationMessage.get(1).waitUntil(visible, 15000).shouldHave(text(" Ошибка Ошибка! Банк отказал в проведении операции."));
    }

    public PurchasePage approvedCreditPurchase(DataHelper.CardInfo info) {
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public PurchasePage declinedCreditPurchase(DataHelper.CardInfo info) {
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getInvalidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public PurchasePage monthValidityCheck(DataHelper.CardInfo info){
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getInvalidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public void monthErrorMessage(){
        dataError.get(0).shouldBe(visible,text("Неверно указан срок действия карты"));
    }

    public PurchasePage monthLoanValidityCheck(DataHelper.CardInfo info){
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getInvalidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public PurchasePage valueOfTheYear(DataHelper.CardInfo info){
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getInvalidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }
    public void yearErrorMessage(){
        dataError.get(0).shouldBe(visible,text("Истёк срок действия карты"));
    }

    public PurchasePage valueOfTheLoanPaymentYear(DataHelper.CardInfo info){
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getInvalidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public PurchasePage nameVerificationOnDebitPayment(DataHelper.CardInfo info){
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getInvalidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public void nameErrorMessage(){
        nameError.get(1).shouldBe(visible,text("Имя должно состоять только из латинских символов"));
    }

    public PurchasePage nameVerificationOnCreditPayment(DataHelper.CardInfo info){
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getValidMonth());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getInvalidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }
    public PurchasePage checkMonthFormat(DataHelper.CardInfo info) {
        buyButton.get(0).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getWrongMonthFormat());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }

    public void getMonthFormatError(){
        monthFormatErrorMessage.get(0).shouldBe(visible,text("Неверный формат"));
    }

    public PurchasePage checkTheMonthFormatWithPaymentOfCredit(DataHelper.CardInfo info) {
        buyInCreditButton.get(1).click();
        cardField.get(0).setValue(info.getValidCard());
        enterMonth.get(1).setValue(info.getWrongMonthFormat());
        enterYear.get(2).setValue(info.getValidYear());
        enterOwner.get(3).setValue(info.getValidName());
        enterACode.get(4).setValue(info.getCode());
        continueButton.get(2).click();
        return new PurchasePage();
    }




}

