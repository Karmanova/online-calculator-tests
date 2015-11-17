package ru.nsu.fit.tests;

import org.openqa.selenium.By;
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

@Title("Copy paste")
public class CopyPasteTest extends AcceptanceTest {

    @Test(dependsOnMethods = {"openPage"})
    @Title("Copy paste")
    @Description("Insert and clean data check")
    @Severity(SeverityLevel.MINOR)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division", "Paste", "Copy", "Clean"})
    public void copyPasteTest() {
        try (Browser browser = BrowserService.openNewBrowser()) {
            browser.openPage(Utilitie.PAGE_URL);

//            browser.click(Utilitie.oneElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1");
//            browser.click(Utilitie.plusElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + ");
//            browser.click(Utilitie.twoElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2");
//            browser.click(Utilitie.minusElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - ");
//            browser.click(Utilitie.threeElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3");
//            browser.click(Utilitie.timesElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * ");
//            browser.click(Utilitie.fourElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4");
//            browser.click(Utilitie.divElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / ");
//            browser.click(Utilitie.fiveElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5");
//            browser.click(Utilitie.plusElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + ");
//            browser.click(Utilitie.sixElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6");
//            browser.click(Utilitie.minusElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - ");
//            browser.click(Utilitie.sevenElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7");
//            browser.click(Utilitie.timesElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * ");
//            browser.click(Utilitie.eightElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8");
//            browser.click(Utilitie.divElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / ");
//            browser.click(Utilitie.nineElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9");
//            browser.click(Utilitie.plusElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9 + ");
//            browser.click(Utilitie.zeroElement);
//            Assert.assertEquals(browser.getValue(Utilitie.inputElement), "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9 + 0");

            String inputString = "1 + 2 - 3 * 4 / 5 + 6 - 7 * 8 / 9 + 0";
            char[] charsInputString = inputString.toCharArray();
            StringBuffer resultStringBuffer = new StringBuffer();
            for (int i = 0; i < charsInputString.length; i++) {
                char[] tmpArr = new char[1];
                tmpArr[0] = charsInputString[i];
                browser.typeText(Utilitie.inputElement, new String(tmpArr));
                Assert.assertEquals(browser.getValue(Utilitie.inputElement), resultStringBuffer.append(charsInputString[i]).toString());
            }

            String tmpResult = browser.getValue(Utilitie.inputElement);

            browser.click(Utilitie.clearElement);

            browser.typeText(Utilitie.inputElement, tmpResult);
            browser.click(Utilitie.equalElement);
            AllureUtils.saveImageAttach("result copy past test screen", browser.makeScreenshot());

        }

    }
}
