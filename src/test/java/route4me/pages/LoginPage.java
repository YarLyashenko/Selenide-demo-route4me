package route4me.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.Boolean.FALSE;

public class LoginPage {
    public static String LOGIN_PAGE_ADDRESS = "https://www.route4me.com/login";

    public RouteEditorPage performLogin(String email, String password) {
        return performLogin(email, password, FALSE);
    }

    public RouteEditorPage performLogin(String email, String password, boolean rememberLogin) {

        $("#strEmail").setValue(email);
        $("#strPassword").setValue(password);

        $("#chkRemember_1").setSelected(rememberLogin);

        $("#submitBtn").submit();

        return page(RouteEditorPage.class);
    }

}
