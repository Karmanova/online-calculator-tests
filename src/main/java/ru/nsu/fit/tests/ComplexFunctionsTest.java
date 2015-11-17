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

@Title("Complex functions")
public class ComplexFunctionsTest extends AcceptanceTest {

    @Test(dependsOnMethods = "openPage")
    @Title("Complex functions")
    @Description("Expessions with complex functions calculation Check")
    @Severity(SeverityLevel.CRITICAL )
    @Features({"Sin", "Ln", "Power", "Copy", "Paste"})
    public void complexFunctionsTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);
            AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
            browser.typeText(Utilitie.inputElement, "(1 + 2) * 5 - 10 / 2 + 0.3 * 2");

            AllureUtils.saveImageAttach("The expression is typed", browser.makeScreenshot());
            browser.click(Utilitie.equalElement);
            AllureUtils.saveImageAttach("Result", browser.makeScreenshot());
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "10.6");
//            AssertionError: expected [1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 + 9 + 0 + ( sin ( 90 ) ) ^ 2]
//                           but found [1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 + 9 + 0+ ( sin ( 90 ) ) ^ 2]
        }

    }
}
