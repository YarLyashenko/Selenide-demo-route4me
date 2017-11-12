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
        int size = $("div.ui-timepicker-div div.ui-slider ").getSize().getWidth();

        setMinutesWithSlider(time, size);
        setHoursWithSlider(time, size);

        $("button.ui-datepicker-close").click();
    }

    private void setMinutesWithSlider(String time, int size) {
        actions().dragAndDropBy(minuteHandle, -size * 2, 0).perform();
        String previousTime;
        int minutesStep = size / 60;

        for (int i = 0; i < 70; i++) {
            if (getMinutes(time).equals(getMinutes(pickedTime.getText()))) {
                return;
            }
            previousTime = pickedTime.getText();
            actions().dragAndDropBy(minuteHandle, minutesStep, 0).perform();
            if (previousTime.equals(pickedTime.getText())) {
                minutesStep++;
            }
        }
    }

    private void setHoursWithSlider(String time, int size) {
        actions().dragAndDropBy(hourHandle, -size * 2, 0).perform();
        String previousTime;
        int hourStep = size / 24;

        actions().dragAndDropBy(hourHandle, -size * 2, 0).perform();
        for (int i = 0; i < 30; i++) {
            if (time.equals(pickedTime.getText())) {
                break;
            }
            previousTime = pickedTime.getText();
            actions().dragAndDropBy(hourHandle, hourStep, 0).perform();
            if (previousTime.equals(pickedTime.getText())) {
                hourStep++;
            }
        }
    }

    private String getMinutes(String time) {
        return time.substring(3, 5);
    }

}
