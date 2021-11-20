package cloud.autotests.tests;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class ApiTests extends TestBase {

    @Test
    @Description("This test verifies a user can add phone cover to card.")
    @DisplayName("Add some product to card")
    public void addPhoneCoverToCardTest() {

        Response addPhoneCoverToCard = given()
                .cookie(authCookie)
                .body("product_attribute_80_2_37=112&" +
                        "product_attribute_80_1_38=114&" +
                        "addtocart_80.EnteredQuantity=1")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/31/1");

        addPhoneCoverToCard.then()
                .statusCode(200)
                .body("success", is(true));
        System.out.println(addPhoneCoverToCard.asString());
    }

    @Description("This test verifies a user can subscribe with email")
    @DisplayName("Subscribe with email")
    @Test
    public void subscribeWithEmailTest() {
        Response subscribeWithEmail =
                given()
                        .cookie(authCookie)
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body("email=asd%40gmail.com")
                        .when()
                        .post("http://demowebshop.tricentis.com/subscribenewsletter");

        subscribeWithEmail.then()
                .statusCode(200)
                .body("Success", is(true))
                .body("Result", is("Thank you for signing up! A verification email has been sent. We appreciate your interest."));

        System.out.println(subscribeWithEmail.asString());
    }

    @Description("This test verifies a user can email a friend about some item in the shop")
    @DisplayName("Email a friend about some item")
    @Test
    public void emailFriendAboutItemTest() {
        Response emailFriendAboutItem = given()
                .cookie(authCookie)
                .body("FriendEmail=wq%40gmail.com&" +
                        "YourEmailAddress=qw%40gmail.com&" +
                        "PersonalMessage=hello+world&" +
                        "send-email=Send+email")
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post("http://demowebshop.tricentis.com/productemailafriend/72");

        emailFriendAboutItem.then()
                .statusCode(200);

        System.out.println(emailFriendAboutItem.asString());
    }
}
