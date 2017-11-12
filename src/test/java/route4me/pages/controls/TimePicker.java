package route4me.pages.controls;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class TimePicker {

    @FindBy(css = "dd.ui_tpicker_time")
    private SelenideElement pickedTime;

    @FindBy(css = "dd.ui_tpicker_hour a.ui-slider-handle")
    private SelenideElement hourHandle;

    @FindBy(css = "dd.ui_tpicker_minute a.ui-slider-handle")
    private SelenideElement minuteHandle;

    public void setTime(String time) {
        setMinutesWithSlider(getMinutes(time));

        actions().dragAndDropBy(hourHandle, -2000, 0).perform();
        for (int i = 0; i < 2000; i++) {
            if (time.equals(pickedTime.getText())) {
                break;
            }
            actions().dragAndDropBy(hourHandle, 4, 0).perform();
        }
        $("button.ui-datepicker-close").click();
    }

    private void setMinutesWithSlider(String expectedMinutes) {
        actions().dragAndDropBy(minuteHandle, -2000, 0).perform();
        for (int i = 0; i < 2000; i++) {
            if (expectedMinutes.equals(getMinutes(pickedTime.getText()))) {
                return;
            }
            actions().dragAndDropBy(minuteHandle, 4, 0).perform();
        }
    }

    private String getMinutes(String time) {
        return time.substring(3, 5);
    }

}
