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

public class BuyTourTest {

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
    @Order(3)
    void findOutTheCreatedDebitPayment() {
        val statusExpected = SQLHelper.receiveCreatedDebitPayment();
        val statusActual = SQLHelper.receiveCreatedPayment();
        assertEquals(statusExpected,statusActual);
    }


    @Test
    @Order(4)
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
    @Order(5)
    void findOutIfADebitPaymentIsSaved() {
        val statusExpected = SQLHelper.debitPayment();
        val statusActual = SQLHelper.transaction();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(6)
    void findOutTheCreatedDebitPayment1() {
        val statusExpected = SQLHelper.receiveCreatedDebitPayment();
        val statusActual = SQLHelper.receiveCreatedPayment();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(7)
    void  checkMonth() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.monthValidityCheck(cardApproved);
        purchasePage.monthErrorMessage();
    }

    @Test
    @Order(8)
    void  yearCheck () {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.valueOfTheYear(cardApproved);
        purchasePage.yearErrorMessage();
    }

    @Test
    @Order(9)
    void  nameVerificationForDebitPayment() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.nameVerificationOnDebitPayment(cardApproved);
        purchasePage.nameErrorMessage();
    }

    @Test
    @Order(10)
    void checkMonthFormat() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.checkMonthFormat(cardApproved);
        purchasePage.getMonthFormatError();
    }
}
