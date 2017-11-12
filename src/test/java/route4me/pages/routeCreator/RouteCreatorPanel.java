package route4me.pages.routeCreator;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import route4me.pages.VerifyAddressPanel;
import route4me.pages.routeCreator.tabs.*;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RouteCreatorPanel {
    public NameTab navigateToNameTab() {
        $("[href='#name']").click();
        return page(NameTab.class);
    }

    public ScheduleTab navigateToScheduleTab() {
        $("[href='#schedule']").click();
        return page(ScheduleTab.class);
    }

    public SharingTab navigateToSharingTab() {
        $("[href='#sharing']").click();
        return page(SharingTab.class);
    }

    public DistanceTab navigateToDistanceTab() {
        $("[href='#distance']").click();
        return page(DistanceTab.class);
    }

    public OptimizationTab navigateToOptimizationTab() {
        $("[href='#route_type']").click();
        return page(OptimizationTab.class);
    }

    public DirectionsTab navigateToDirectionsTab() {
        $("[href='#directions']").click();
        return page(DirectionsTab.class);
    }

    public TurnRestrictionsTab navigateToTurnRestrictionsTab() {
        $("[href='#turns']").click();
        return page(TurnRestrictionsTab.class);
    }

    public UserTab navigateToUserTab() {
        $("[href='#user']").click();
        return page(UserTab.class);
    }

    public void clickCreateRoute() {
        $("div.modal-footer button[data-bb-handler=confirm]").click();
    }

    public void closePanel() {
        $("div.modal-footer button[data-bb-handler=cancel]").click();
    }

    public VerifyAddressPanel continueReview() {
        $("div.modal-footer button[data-bb-handler=review]").click();
        return page(VerifyAddressPanel.class);
    }

    public void uploadFile(File file) {
        $("div#upload_addresses_dropzone").shouldBe(visible);

        dropFile(file, $("div#upload_addresses_dropzone"), 0, 0);

        //wait for processing the file
        sleep(2000);

    }

    private void dropFile(File file, SelenideElement target, int offsetX, int offsetY) {
        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";
        SelenideElement input = $((WebElement) Selenide.executeJavaScript(JS_DROP_FILE, target, offsetX, offsetY));
        input.uploadFile(file);
    }
}
