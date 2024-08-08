package tests.iOS;

import lib.iOSTestCase;
import lib.ui.WeclomePageObject;
import org.junit.Test;

public class GetStartedTest extends iOSTestCase {

    @Test
    public void testPassThrouhWelcome()
    {
        WeclomePageObject WelcomePage = new WeclomePageObject(driver);

        WelcomePage.waitForLerningMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDateCollectedText();
        WelcomePage.clickGetStartedButton();

    }
}
