package ru.nsu.fit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.nsu.fit.services.browser.Browser;
import ru.nsu.fit.services.browser.BrowserService;
import ru.nsu.fit.services.browser.Utilitie;
import ru.nsu.fit.shared.AllureUtils;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * Created by Анастасия on 17.11.2015.
 */

@Title("Keyboard insert")
public class KeyboardInsertTest extends AcceptanceTest {

    @Test(dependsOnMethods = "openPage")
    @Title("Keyboard insert")
    @Description("Keyboard insert Check")
    @Severity(SeverityLevel.CRITICAL )
    @Features({"Subtraction", "Addition", "Division", "Multiplication", "Power", "Sin", "Keyboard insert"})
    public  void keyboardInsertTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);
            AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
            browser.typeText(Utilitie.inputElement, "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 + 9 + 0");
            String tmpResult = browser.getValue(Utilitie.inputElement);
            Assert.assertEquals(tmpResult, "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 + 9 + 0");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());

            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "-40.4");
            AllureUtils.saveImageAttach("2", browser.makeScreenshot());
            browser.click(Utilitie.clearElement);

            browser.typeText(Utilitie.inputElement, tmpResult);
            browser.typeText(Utilitie.inputElement, " + ( sin ( 90 ) ) ^ 2");
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 + 9 + 0 + ( sin ( 90 ) ) ^ 2");
            AllureUtils.saveImageAttach("3", browser.makeScreenshot());

            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "-39.4");
            AllureUtils.saveImageAttach("4", browser.makeScreenshot());
        }

    }
}
