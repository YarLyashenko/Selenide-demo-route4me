package route4me.pages.routeCreator.tabs;

import static com.codeborne.selenide.Selenide.$;

public class TurnRestrictionsTab {
    public TurnRestrictionsTab permitUTurns(boolean permitted) {
        $("div#uTurnAvoidance input[name=uturn][value='1']").setSelected(permitted);
        $("div#uTurnAvoidance input[name=uturn][value='2']").setSelected(!permitted);
        return this;
    }

    public TurnRestrictionsTab permitLeftTurns(boolean permitted) {
        $("div#leftTurnAvoidance input[name=leftturn][value='1']").setSelected(permitted);
        $("div#leftTurnAvoidance input[name=leftturn][value='2']").setSelected(!permitted);
        return this;
    }

    public TurnRestrictionsTab permitRightTurns(boolean permitted) {
        $("div#rightTurnAvoidance input[name=rightturn][value='1']").setSelected(permitted);
        $("div#rightTurnAvoidance input[name=rightturn][value='2']").setSelected(!permitted);
        return this;
    }

}
