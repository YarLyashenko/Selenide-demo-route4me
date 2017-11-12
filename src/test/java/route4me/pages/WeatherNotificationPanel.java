package route4me.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WeatherNotificationPanel {

    public RouteDetailsPage clickApply() {
        $("div.modal-footer button[data-bb-handler=ok]").click();
        return page(RouteDetailsPage.class);
    }

    public RouteDetailsPage clickSkip() {
        $("div.modal-footer button[data-bb-handler=skip]").click();
        return page(RouteDetailsPage.class);
    }

    public VerifyAddressPanel clickCancel() {
        $("div.modal-footer button[data-bb-handler=cancel]").click();
        return page(VerifyAddressPanel.class);
    }
}
