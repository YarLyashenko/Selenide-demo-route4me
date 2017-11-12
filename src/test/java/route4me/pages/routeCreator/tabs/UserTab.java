package route4me.pages.routeCreator.tabs;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserTab {
    public UserTab selectVehicle(String vehicle) {
        SelenideElement assignVehiclePanel = $(By.xpath("//label[contains(text(), 'Assign Vehicle')]"));
        assignVehiclePanel.find(By.xpath(".//div[contains(@class, 'selectize-control')]")).click();
        assignVehiclePanel.find(By.xpath(".//div[contains(@class, 'option') and contains(text(), '" + vehicle + "')]")).click();
        return this;
    }

    public UserTab selectUser(String user) {
        SelenideElement assignVehiclePanel = $(By.xpath("//label[contains(text(), 'Assign to User')]"));
        assignVehiclePanel.find(By.xpath(".//div[contains(@class, 'selectize-control')]")).click();
        assignVehiclePanel.find(By.xpath(".//div[contains(@class, 'option') and contains(text(), '" + user + "')]")).click();
        return this;
    }
}
