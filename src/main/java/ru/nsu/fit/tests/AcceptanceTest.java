package ru.nsu.fit.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.nsu.fit.services.browser.Browser;
import ru.nsu.fit.services.browser.BrowserService;
import ru.nsu.fit.services.browser.Utilitie;
import ru.nsu.fit.shared.AllureUtils;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Timur Zolotuhin (tzolotuhin@gmail.com)
 */

@Title("Acceptance test")
public class AcceptanceTest {

    @Test
    @BeforeSuite
    @Title("Open page")
    @Description("Check that we can open page with Online Calculator")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void openPage() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            AllureUtils.saveTextLog("Open page");
            browser.openPage(Utilitie.PAGE_URL);
            AllureUtils.saveTextLog("The page was opened successfully");
            AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
        }
    }
}
