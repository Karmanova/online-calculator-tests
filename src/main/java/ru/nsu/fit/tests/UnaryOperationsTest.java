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

@Title("Unary operations")
public class UnaryOperationsTest extends AcceptanceTest {

    @Test(dependsOnMethods = "openPage")
    @Title("Unary operations")
    @Description("Unary operations Check")
    @Severity(SeverityLevel.MINOR )
    @Features({ "Addition", "Backets", "Unary"})
    public void unaryOperationsTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);

            browser.typeText(Utilitie.inputElement, "-1");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "-1");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());

            browser.typeText(Utilitie.inputElement, "( ( 1 + 1 ) ) )");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "Error");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());
        }
    }
}
