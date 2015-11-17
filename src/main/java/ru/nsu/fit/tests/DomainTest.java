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

@Title("Domain")
public class DomainTest extends AcceptanceTest {

    @Test(dependsOnMethods = {"openPage"})
    @Title("Domain")
    @Description("Operations with values on the edge of domain Check")
    @Severity(SeverityLevel.MINOR )
    @Features({"Domain", "Addition", "Subtraction", "Infinity"})
    public void domainTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);
            browser.typeText(Utilitie.inputElement, "1000000 + 3009");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "Infinity");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());

            browser.click(Utilitie.plusElement);
            browser.typeText(Utilitie.inputElement, "3009");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "Error");
            AllureUtils.saveImageAttach("2", browser.makeScreenshot());

            browser.click(Utilitie.timesElement);
            browser.click(Utilitie.minusElement);
            browser.click(Utilitie.oneElement);
            browser.click(Utilitie.equalElement);
            browser.click(Utilitie.plusElement);
            browser.typeText(Utilitie.inputElement, "3009");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "Error");
            AllureUtils.saveImageAttach("3", browser.makeScreenshot());
        }

    }
}
