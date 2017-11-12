package route4me.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import route4me.pages.routeCreator.RouteCreatorPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RouteEditorPage {

    @FindBy(id = "input-modes-wrapper")
    private SelenideElement inputModesWrapper;
    @FindBy(className = "promo-offer-dialog")
    private SelenideElement promoOfferDialog;

    public void clickPlanNewRoute() {
        $("#routes-submenu").click();
        $("#new-route").click();

    }

    public RouteCreatorPanel clickUploadAFile() {
        inputModesWrapper.find("#create_route_from_file_step_link").click();
        return page(RouteCreatorPanel.class);
    }

    public void waitForInputModesWrapper() {
        inputModesWrapper.shouldBe(visible);
    }

    public void closePromoOffer(boolean isUserInterested) {
        promoOfferDialog.shouldBe(visible);
        if (isUserInterested) {
            promoOfferDialog.find("#form-validation-field-0").click();
            promoOfferDialog.find("#btnYes").click();
        } else {
            promoOfferDialog.find("#btnNo").click();
        }
    }


}
