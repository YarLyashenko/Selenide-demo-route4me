package route4me.pages.routeCreator.tabs;

import static com.codeborne.selenide.Selenide.$;

public class DirectionsTab {
    public void selectDisableOptimization(String navigateBy, String travelMode, String highwayAndTolls) {
        $("select[name=strOptimize]").selectOptionContainingText(navigateBy);
        $("select[name=travelMode]").selectOptionContainingText(travelMode);
        $("select[name=strAvoid]").selectOptionContainingText(highwayAndTolls);
    }
}
