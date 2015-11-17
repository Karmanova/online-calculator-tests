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

@Title("Arithmetic operations")
public class ArithmeticOperationsTest extends AcceptanceTest {

    @Test(dependsOnMethods = "openPage")
    @Title("Arithmetic operations")
    @Description("Arithmetic operations check")
    @Severity(SeverityLevel.CRITICAL )
    @Features({"Subtraction", "Multiplication", "Addition", "Division", "Power", "Brackets", "Rational", "Zero"})
    public void arithmeticOperationsTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);

            String inputString = "(0.1 + 0.2) * 0.3";
            char[] charsInputString = inputString.toCharArray();
            StringBuffer resultStringBuffer = new StringBuffer();
            for (int i = 0; i < charsInputString.length; i++) {
                char[] tmpArr = new char[1];
                tmpArr[0] = charsInputString[i];
                browser.typeText(Utilitie.inputElement, new String(tmpArr));
                Assert.assertEquals(browser.getValue(Utilitie.inputElement), resultStringBuffer.append(charsInputString[i]).toString());
            }
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "0.09");
            AllureUtils.saveImageAttach("1", browser.makeScreenshot());

            browser.typeText(Utilitie.inputElement, "^2");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "0,0081");
            AllureUtils.saveImageAttach("2", browser.makeScreenshot());

            browser.typeText(Utilitie.inputElement, "+ 1000000");
            browser.click(Utilitie.equalElement);
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "Eroor");
            AllureUtils.saveImageAttach("3", browser.makeScreenshot());
        }
    }
}
