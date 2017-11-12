package route4me;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import route4me.pages.*;
import route4me.pages.routeCreator.RouteCreatorPanel;
import route4me.pages.routeCreator.tabs.ScheduleTab;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static route4me.pages.LoginPage.LOGIN_PAGE_ADDRESS;

@Listeners({ScreenShooter.class})
public class AddRouteTest {

    private static final String SCHEDULE_DATE = "20 January 2018";
    private static final String ROUTE_NAME = "My the very best route! " + now();
    private static final String SCHEDULE_TIME = "11:02 am";
    private static final String SERVICE_TIME = "00:05";
    private static final String EMAIL = "ubuntu103@yandex.ua";
    private static final String PASSWORD = "Create Your Route4Me Account";
    private static final String SHARING_EMAIL = "ubuntu103@yandex.ru";
    private static final String DISTANCE_OPTION = "Drive Time Optimization";
    private static final String NAVIGATE_BY = "Distance";
    private static final String TRAVEL_MODE = "Driving";
    private static final String HIGHWAY_AND_TOLLS = "No Restrictions";
    private static final String VEHICLE = "MyTestVehicle";
    private static final String USER = "John Doe";
    private static final File ROUTE_FILE = new File("src/test/resources/routes/singleDepotSingleDriver9Stops.xlsx");
    private static final int STOPS_AT_THE_ROUTE = 9;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
    }

    @Test
    public void loginAndAddRouteFromFile() {
        LoginPage loginPage = open(LOGIN_PAGE_ADDRESS, LoginPage.class);
        loginPage.performLogin(EMAIL, PASSWORD);

        RouteEditorPage editorPage = page(RouteEditorPage.class);
        editorPage.closePromoOffer(FALSE);
        editorPage.clickPlanNewRoute();
        editorPage.clickUploadAFile();

        RouteCreatorPanel routeCreator = page(RouteCreatorPanel.class);
        routeCreator.navigateToNameTab().populateNameValue(ROUTE_NAME);
        routeCreator.navigateToScheduleTab();

        ScheduleTab scheduleTab = page(ScheduleTab.class);
        scheduleTab.setDate(SCHEDULE_DATE);
        scheduleTab.setTime(SCHEDULE_TIME);
        scheduleTab.setServiceTime(SERVICE_TIME);

        routeCreator.navigateToSharingTab().populateEmailRouteValue(SHARING_EMAIL);
        routeCreator.navigateToDistanceTab().selectDistanceOptions(DISTANCE_OPTION);
        routeCreator.navigateToOptimizationTab().selectDisableOptimization().selectEndRouteAtAnyAddress();
        routeCreator.navigateToDirectionsTab().selectDisableOptimization(NAVIGATE_BY, TRAVEL_MODE, HIGHWAY_AND_TOLLS);
        routeCreator.navigateToTurnRestrictionsTab().permitUTurns(TRUE).permitLeftTurns(TRUE).permitRightTurns(TRUE);
        routeCreator.navigateToUserTab().selectVehicle(VEHICLE).selectUser(USER);

        routeCreator.clickCreateRoute();
        routeCreator.uploadFile(ROUTE_FILE);
        routeCreator.continueReview();

        VerifyAddressPanel verifyAddressPanel = page(VerifyAddressPanel.class);
        verifyAddressPanel.openReviewTab().confirmAllAddresses();
        verifyAddressPanel.finishImport();

        WeatherNotificationPanel weatherPanel = page(WeatherNotificationPanel.class);
        weatherPanel.clickSkip();

        RouteDetailsPage routeDetails = page(RouteDetailsPage.class);
        routeDetails.waitForRouteDetailsPageLoad();
        routeDetails.getRouteStops().shouldHave(size(STOPS_AT_THE_ROUTE));
        routeDetails.getRouteStops().forEach(stop -> stop.click());
    }
}
