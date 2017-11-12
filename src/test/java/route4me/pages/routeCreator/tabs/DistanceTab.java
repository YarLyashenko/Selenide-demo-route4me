package route4me.pages.routeCreator.tabs;


import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.ImmutableMap;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.$$;

public class DistanceTab {
    private static ImmutableMap<String, String> nameToValuesMap = ImmutableMap.<String, String>builder()
            .put("Drive Time Optimization", "road-line")
            .put("Straight Line Optimization", "straight-line")
            .put("Big City Optimization", "big-city").build();

    public void selectDistanceOptions(String optionName) {
        Collection<SelenideElement> options = $$("input[name=single_distance]");
        options.stream()
                .filter(op -> op.getValue().trim().equals(nameToValuesMap.get(optionName)))
                .map(elem -> elem.setSelected(true));
    }
}
