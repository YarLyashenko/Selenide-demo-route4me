package route4me.pages.routeCreator.tabs;

import static com.codeborne.selenide.Selenide.$;

public class OptimizationTab {
    public OptimizationTab selectDisableOptimization() {
        $("input[name=routeType][value=disable_optimization]").setSelected(true);
        $("input#chkDisableOptimization").setSelected(true);
        return this;
    }

    public OptimizationTab selectEndRouteAtAnyAddress() {
        $("input[name=endType][value=any]").setSelected(true);
        return this;
    }

    public OptimizationTab selectEndRouteAtDepartureAddress() {
        $("input[name=endType][value=round]").setSelected(true);
        return this;
    }
}
