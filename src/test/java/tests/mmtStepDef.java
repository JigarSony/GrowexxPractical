package tests;

import Utility.InitDriver;
import Utility.PropertyUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Utility.DriverUtility.timeout;

public class mmtStepDef extends InitDriver {
    PropertyUtil propUtil = new PropertyUtil();
    SoftAssert softAssert = new SoftAssert();

    String expFlightName;
    int flightCount;
    String actulFlightName;

    @Before
    public void browserInit() {
        driverInit();
    }

    @After
    public void closeBrowser() {
        tearDown();
    }

    @Given("User is on MakeMyTrip homePage")
    public void user_is_on_make_my_trip_home_page() throws IOException {
        getDriver().get(propUtil.getGlobalProperty("url"));

        Cookie ck = new Cookie("PERSONAL_emperiaResponse_isLogin", "true");
        getDriver().manage().addCookie(ck);

    }

    @When("User click on Login button")
    public void user_click_on_login_button() {
        getDriver().findElement(By.cssSelector(".makeFlex.hrtlCenter.font10.makeRelative.lhUser.userLoggedOut")).click();

    }

    @Then("Verify Login Signup Pop up should be displayed")
    public void verify_login_signup_pop_up_should_be_displayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(getDriver().findElement(By.cssSelector(".modalTitle.makeFlex.hrtlCenter.font26.latoBold.appendBottom5")).isDisplayed());
    }

    @When("User Enter Username and click on Continue button")
    public void user_enter_username_and_click_on_continue_button() throws IOException {
        getDriver().findElement(By.cssSelector("#username")).sendKeys(propUtil.getGlobalProperty("userName"));

        getDriver().findElement(By.cssSelector("button.capText.font16")).click();
        timeout(3000);

    }

    @When("User Enter Password and click on Login button")
    public void user_enter_password_and_click_on_login_button() throws IOException {
        getDriver().findElement(By.cssSelector("input#password")).sendKeys(propUtil.getGlobalProperty("passWord"));

        getDriver().findElement(By.cssSelector("button.capText.font16")).click();
        timeout(2000);

    }

    @Then("Verify User redirected to MMT Homepage")
    public void verify_user_redirected_to_mmt_homepage() {
        String usernNametxt = getDriver().findElement(By.xpath("//*[@id='SW']//p[@data-cy='loggedInUser']")).getText();
        Assert.assertEquals("Hey Jigar", usernNametxt);
        timeout(2000);
    }

    @When("User Selects fromLocation toLocation selectDate passengerType travelClass and click on Search")
    public void user_select_from_location_to_location_select_date_passenger_type_travel_class_and_click_on_search() throws IOException {
        getDriver().findElement(By.cssSelector("#fromCity")).sendKeys(propUtil.getGlobalProperty("fromLocation"));
        timeout(1000);
        getDriver().findElement(By.cssSelector("ul > li#react-autowhatever-1-section-0-item-0")).click();

        getDriver().findElement(By.cssSelector("#toCity")).sendKeys(propUtil.getGlobalProperty("toLocation"));
        timeout(1000);

        getDriver().findElement(By.cssSelector("ul > li#react-autowhatever-1-section-0-item-0")).click();

        timeout(1000);

        getDriver().findElement(By.cssSelector("p[data-cy='departureDate']")).click();
        timeout(3000);
        getDriver().findElement(By.xpath("(//div[@aria-disabled='false']//p[contains(text(),'25')])[1]")).click();
        timeout(3000);

        getDriver().findElement(By.cssSelector("label[for='travellers']")).click();
        timeout(2000);
        getDriver().findElement(By.cssSelector("li[data-cy='adults-2']")).click();
        timeout(1000);
        getDriver().findElement(By.cssSelector("li[data-cy='travelClass-2']")).click();
        timeout(1000);
        getDriver().findElement(By.cssSelector("button.btnApply")).click();
        timeout(2000);

        getDriver().findElement(By.cssSelector("a.widgetSearchBtn")).click();
        timeout(5000);
    }

    @Then("Verify User redirected to flightSearch Page")
    public void verify_user_redirected_to_flight_search_page() {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("flight"));

    }

    @When("User select checkbox for Air India")
    public void user_select_checkbox_for_air_india() {
        getDriver().findElements(By.className("customCheckbox")).get(0).click();
        actulFlightName = getDriver().findElements(By.xpath("//div[@class = 'listingCard']//span[@class='boldFont blackText airlineName']")).get(0).getText();
        expFlightName = getDriver().findElements(By.className("truncate")).get(0).getText();
        flightCount = getDriver().findElements(By.className("airlineName")).size();
    }

    @Then("Verify the number of total flights for AirIndia")
    public void verify_the_number_of_total_flights_for_air_india() throws IOException {
        Assert.assertEquals(Integer.parseInt(propUtil.getGlobalProperty("actualFlightCount")), flightCount);
        Assert.assertEquals(actulFlightName, expFlightName);
    }
}
