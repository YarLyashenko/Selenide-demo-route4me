package route4me.pages.routeCreator.tabs;

import route4me.pages.controls.DatePicker;
import route4me.pages.controls.TimePicker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ScheduleTab {
    public DatePicker openDatePicker() {

        $("button.datepicker-button").click();
        return page(DatePicker.class);
    }

    public void setDate(String date) {
        openDatePicker().setDate(date);
    }

    public TimePicker openTimePicker() {

        $("button.timepicker-button").click();
        return page(TimePicker.class);
    }

    public void setTime(String time) {
        openTimePicker().setTime(time);
    }

    public void setServiceTime(String serviceTime) {
        $("input[name=strServiceTimeOverride]").setValue(serviceTime);
    }
}
