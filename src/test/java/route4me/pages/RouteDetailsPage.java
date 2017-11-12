package route4me.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RouteDetailsPage {
    public ElementsCollection getRouteStops() {
        return $$("div#addressesView div.list-group-item");
    }

    public void waitForRouteDetailsPageLoad() {
        $("div#routerMap").shouldBe(visible);
        $("div#viewDirectionsTable").shouldBe(visible);
        $("div#addressesView div.list-group-item").shouldBe(visible);
    }
}
