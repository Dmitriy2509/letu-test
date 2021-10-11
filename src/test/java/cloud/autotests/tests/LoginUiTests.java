package cloud.autotests.tests;

import cloud.autotests.config.App;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginUiTests extends TestBase {

//    @Test
//    @Description("This test verifies a registered user can log in.")
//    @DisplayName("Successful login")
//    void loginTest() {
//
//        step("Open the 'login' page", () -> {
//            open("/login");
//        });
//
//        step("Set the 'freportsandoffers@gmail.com' email onto the 'Email' field", () -> {
//            $(By.xpath("//input[@type='email']")).setValue(App.config.userLogin());
//        });
//
//        step("Set the 'qwerty' password onto the 'Пароль' field", () -> {
//            $(By.xpath("//input[@type='password']")).setValue(App.config.userPassword());
//        });
//
//        step("Click on the 'Войти' button", () -> {
//            $(By.xpath("//button[text()='Войти']")).shouldBe(visible, Duration.ofMillis(50000)).click();
//        });
//
//        step("Check success authorization", () -> {
//            $(By.xpath("//span[text()='Личный кабинет']")).shouldBe(visible, Duration.ofMillis(50000));
//        });
//    }

//    @Test
//    @Description("This test verifies a registered user can not log in with valid email and wrong password.")
//    @DisplayName("Login with wrong password")
//    void loginWithWrongPasswordTest() {
//
//        step("Open the 'login' page", () -> {
//            open("/login");
//        });
//
//        step("Set the 'freportsandoffers@gmail.com' email onto the 'Email' field", () -> {
//            $(By.xpath("//input[@type='email']")).setValue(App.config.userLogin());
//        });
//
//        step("Set the 'qweqqty' password onto the 'Пароль' field", () -> {
//            $(By.xpath("//input[@type='password']")).setValue("qweqqty");
//        });
//
//        step("Click on the 'Войти' button", () -> {
//            $(By.xpath("//button[text()='Войти']")).shouldBe(visible, Duration.ofMillis(50000)).click();
//        });
//
//        step("The 'Пожалуйста, проверьте правильность логина и пароля.' message is displayed", () -> {
//            $(By.xpath("//div[text()='Пожалуйста, проверьте правильность логина и пароля.']")).shouldBe(visible, Duration.ofMillis(50000));
//        });
//    }
//
//    @Test
//    @Description("This test verifies a registered user can not log in with wrong email.")
//    @DisplayName("Login with wrong email format")
//    void loginWithWrongEmailFormatTest() {
//
//        step("Open the 'login' page", () -> {
//            open("/login");
//        });
//
//        step("Set the 'freportsandoffers@g' email onto the 'Email' field", () -> {
//            $(By.xpath("//input[@type='email']")).setValue("freportsandoffers@g");
//        });
//
//        step("Set the 'qwerty' password onto the 'Пароль' field", () -> {
//            $(By.xpath("//input[@type='password']")).setValue("'qwerty");
//        });
//
//        step("Click on the 'Войти' button", () -> {
//            $(By.xpath("//button[text()='Войти']")).shouldBe(visible, Duration.ofMillis(50000)).click();
//        });
//
//        step("The 'Пожалуйста, проверьте правильность логина и пароля.' message is displayed", () -> {
//            $(By.xpath("//div[text()='Неверный формат email.']")).shouldBe(visible, Duration.ofMillis(50000));
//        });
//    }

    @Test
    @Description("This test verifies the 'ПОДПИСАТЬСЯ НА РАССЫЛКУ LETU.UA' field is displayed on the page")
    @DisplayName("Check the 'ПОДПИСАТЬСЯ НА РАССЫЛКУ LETU.UA' field is displayed")
    void checkSubscriptionFieldIsDisplayedTest() {

        step("Open the main' page", () -> {
            open("");
        });

        step("Scroll to the 'ПОДПИСАТЬСЯ НА РАССЫЛКУ LETU.UA' field", () -> {
            $(By.xpath("//*[@id='subscribeFormEmail']")).scrollIntoView(true);

        });

        step("Check the 'ПОДПИСАТЬСЯ НА РАССЫЛКУ LETU.UA' field is displayed", () -> {
            $(By.xpath("//*[@id='subscribeFormEmail']")).shouldBe(visible, Duration.ofMillis(50000));
        });
    }

    @Test
    @Description("Check search field is displayed on the header")
    @DisplayName("Check search field is displayed on the header")
    void checkSearchFieldIsDisplayedOnHeaderTest() {

        step("Open the main page", () -> {
            open("");
        });

        step("Check the search field is displayed on the page", () -> {
            $(By.xpath("//input[@type='search']")).shouldBe(visible, Duration.ofMillis(50000));
        });
    }

    @Test
    @Description("This test verifies phone number is displayed on the header")
    @DisplayName("Check phone number is displayed on the header")
    void checkPhoneNumberIsDisplayedOnTheHeaderTest() {

        step("Open the main page", () -> {
            open("");
        });

        step("Check the phone number is displayed on the page", () -> {
            $(By.xpath("//header//*[text()='0-800-50-50-07']")).shouldBe(visible, Duration.ofMillis(50000));
        });
    }

//    @Test
//    @Description("This test verifies language panel is displayed on the header")
//    @DisplayName("Check language panel is displayed on the header")
//    void checkLanguagePanelIsDisplayedOnTheHeaderTest() {
//
//        step("Open the main page", () -> {
//            open("");
//        });
//
//        step("Check language panel is displayed on the header", () -> {
//            $(By.xpath("//ul[@class='language-selector-tabs']")).shouldBe(visible ,Duration.ofMillis(50000));
//        });
//    }
//
//    @Test
//    @Description("This test verifies information about payment is displayed after following link")
//    @DisplayName("Check information about payment is displayed after following information link")
//    void checkInformationAboutPaymentIsDisplayedAfterFollowingInformationLinkTest() {
//
//        step("Open the main page", () -> {
//            open("");
//        });
//
//        step("Scroll down to the footer", () -> {
//            $(By.xpath("//*[@id='subscribeFormEmail']")).scrollIntoView(true);
//
//        });
//
//        step("Click on the icon under the 'Способы оплат' text", ()->{
//            $(By.xpath("//*[contains(@class,'LETUR-FooterPaymentLink')]//a[@href='/ru/payments']"))
//                    .shouldBe(visible, Duration.ofMillis(50000)).click();
//        });
//
//        step("Check information about payment is displayed on the page after clicking the icon", () -> {
//            $(By.xpath("//div[@class='custom-info-page']//*[text()='Способы оплаты']")).shouldBe(visible, Duration.ofMillis(50000));
//        });
//    }
}
