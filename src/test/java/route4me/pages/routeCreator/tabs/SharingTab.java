package route4me.pages.routeCreator.tabs;

import static com.codeborne.selenide.Selenide.$;

public class SharingTab {
    public void populateEmailRouteValue(String email) {
        $("[name=strRouteEmail]").setValue(email);
    }
}
