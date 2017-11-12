package route4me.pages.routeCreator.tabs;

import static com.codeborne.selenide.Selenide.$;

public class NameTab {
    public void populateNameValue(String name) {
        $("[name=strRouteName]").setValue(name);
    }
}
