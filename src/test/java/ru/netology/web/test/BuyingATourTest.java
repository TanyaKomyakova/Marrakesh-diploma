package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;
import ru.netology.web.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BuyingATourTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @Order(1)
    void successfulTourPurchase() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();
        val statusExpected = "APPROVED";
        val statusActual = SQLHelper.getPurchaseInformation();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(2)
    void getADebitPayment() {
        val statusExpected = SQLHelper.debitPayment();
        val statusActual = SQLHelper.transaction();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(5)
    void tourPurchaseDeclined() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
        val statusExpected = "DECLINED";
        val statusActual = SQLHelper.getPurchaseInformation();
        assertEquals(statusExpected,statusActual);
    }
    @Test
    @Order(6)
    void findOutIfADebitPaymentIsSaved() {
        val statusExpected = SQLHelper.debitPayment();
        val statusActual = SQLHelper.transaction();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(3)
    void successfulPurchaseOfTheTourOnCredit() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedCreditPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();
        val statusExpected = "APPROVED";
        val statusActual = SQLHelper.getInformationAboutBuyingOnCredit();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(4)
    void getACreditPayment() {
        val statusExpected = SQLHelper.creditPayment();
        val statusActual = SQLHelper.transaction();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(7)
    void declinedPurchaseOfTheTourOnCredit() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedCreditPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
        val statusExpected = "DECLINED";
        val statusActual = SQLHelper.getInformationAboutBuyingOnCredit();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(8)
    void findOutIfACreditPaymentIsSaved() {
        val statusExpected = SQLHelper.creditPayment();
        val statusActual = SQLHelper.transaction();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(9)
    void  checkMonth() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.monthValidityCheck(cardApproved);
        purchasePage.monthErrorMessage();
    }

    @Test
    @Order(10)
    void  checkingTheMonthWhenReceivingALoan() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.monthLoanValidityCheck(cardApproved);
        purchasePage.monthErrorMessage();
    }

    @Test
    @Order(11)
    void  yearCheck () {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.valueOfTheYear(cardApproved);
        purchasePage.yearErrorMessage();
    }

    @Test
    @Order(12)
    void  checkingTheYearWhenReceivingALoan() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.valueOfTheLoanPaymentYear(cardApproved);
        purchasePage.yearErrorMessage();
    }

    @Test
    @Order(13)
    void  nameVerificationForDebitPayment() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.nameVerificationOnDebitPayment(cardApproved);
        purchasePage.nameErrorMessage();
    }

    @Test
    @Order(14)
    void  nameVerificationForCreditPayment() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.nameVerificationOnCreditPayment(cardApproved);
        purchasePage.nameErrorMessage();
    }

    @Test
    @Order(15)
    void checkMonthFormat() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.checkMonthFormat(cardApproved);
        purchasePage.getMonthFormatError();
    }

    @Test
    @Order(16)
    void  checkTheMonthFormatWhenBuyingOnCredit() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.checkTheMonthFormatWithPaymentOfCredit(cardApproved);
        purchasePage.getMonthFormatError();
    }
}
