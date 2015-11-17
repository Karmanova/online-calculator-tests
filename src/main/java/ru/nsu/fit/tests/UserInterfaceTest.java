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

@Title("User interface")
public class UserInterfaceTest extends AcceptanceTest{

    @Test(dependsOnMethods = "openPage")
    @Title("User interface")
    @Description("User interface check")
    @Severity(SeverityLevel.CRITICAL )
    @Features({"Subtraction", "Addition", "Division", "Multipliation", "Infinity", "Clean", "UI"})
    public void userInterfaceTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);

            browser.click(Utilitie.oneElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1");
            browser.click(Utilitie.plusElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + ");
            browser.click(Utilitie.twoElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2");
            browser.click(Utilitie.minusElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - ");
            browser.click(Utilitie.threeElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3");
            browser.click(Utilitie.timesElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * ");
            browser.click(Utilitie.fourElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4");
            browser.click(Utilitie.divElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / ");
            browser.click(Utilitie.fiveElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5");
            browser.click(Utilitie.plusElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + ");
            browser.click(Utilitie.sixElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6");
            browser.click(Utilitie.minusElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - ");
            browser.click(Utilitie.sevenElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7");
            browser.click(Utilitie.timesElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * ");
            browser.click(Utilitie.eightElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8");
            browser.click(Utilitie.divElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / ");
            browser.click(Utilitie.nineElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9");
            browser.click(Utilitie.plusElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9 + ");
            browser.click(Utilitie.zeroElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9 + 0");

//            browser.click(Utilitie.equalElement);
//            double res = Utilitie.round(browser.getValue(Utilitie.inputElement), 1000);
//            Assert.assertEquals(res, 0.377);
//            AllureUtils.saveImageAttach("1", browser.makeScreenshot());
//
//            browser.click(Utilitie.clearElement);
//            AllureUtils.saveImageAttach("2", browser.makeScreenshot());
        }

    }

}
