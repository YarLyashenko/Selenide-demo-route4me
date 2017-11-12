package route4me.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VerifyAddressPanel {
    public VerifyAddressPanel openReviewTab() {
        $("a[href='#medium_conf_tab_content']").click();
        return this;
    }

    public WeatherNotificationPanel finishImport() {

        $("div.modal-footer button[data-bb-handler=import]").shouldBe(enabled).shouldBe(visible);
        $("div.modal-footer button[data-bb-handler=import]").hover().click();
        return page(WeatherNotificationPanel.class);
    }

    public VerifyAddressPanel confirmAllAddresses() {
        $$("div.address-wrapper.alternatives").forEach(this::confirmAddress);
        //loading
        $("div.modal-footer button[data-bb-handler=import].btn-disable").shouldBe(visible);
        $("div.modal-footer button[data-bb-handler=import].btn-disable").shouldBe(hidden);
        return this;
    }

    private void confirmAddress(SelenideElement element) {
        element.find(By.cssSelector("a.address-text-edit-toggler")).hover().click();
        element.find(By.cssSelector("button.ok-button")).click();
    }

    public void waitUntilLoadingMessageDisappears() {
        $("div.blockUI.blockMsg.blockElement").shouldBe(hidden);
    }
}
