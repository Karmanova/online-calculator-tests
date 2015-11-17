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

@Title("Non-Standart values")
public class NonStandartValuesTest extends AcceptanceTest {

    @Test(dependsOnMethods = {"openPage"})
    @Title("Non-standart values")
    @Description("Operations with NaN and Infinity Check")
    @Severity(SeverityLevel.CRITICAL )
    @Features({"Subtraction", "Addition", "Division", "NaN", "Infinity", "Zero"})
    public void nonStandartValuestest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);
            AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
            browser.typeText(Utilitie.inputElement, "1000000 - 3009");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "996991");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());

            browser.click(Utilitie.divElement);
            browser.click(Utilitie.zeroElement);
            browser.click(Utilitie.equalElement);
            String tmpResult = browser.getValue(Utilitie.inputElement);
            Assert.assertEquals(tmpResult, "Infinity");
            AllureUtils.saveImageAttach("2", browser.makeScreenshot());

            browser.click(Utilitie.divElement);
            browser.typeText(Utilitie.inputElement, "-Infinity");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "NaN");
            AllureUtils.saveImageAttach("3", browser.makeScreenshot());

            browser.click(Utilitie.timesElement);
            browser.typeText(Utilitie.inputElement, "2005");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "NaN");
            AllureUtils.saveImageAttach("4", browser.makeScreenshot());

            browser.click(Utilitie.clearElement);
            AllureUtils.saveImageAttach("clear result", browser.makeScreenshot());
        }
    }

}
