package org.fundacionjala.sfdc.pages.solutions;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class represents Solution page and its options.
 *
 * @author Monica Pardo
 * @since 6/24/2015.
 */
public class SolutionsHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Solutions:')]")
    private WebElement solutionSection;

    /**
     * This method verifies whether the user is on Solution page.
     *
     * @return true if so and false if not.
     */
    public boolean isUserInSolutionsTab() {
        return isWebElementVisible(solutionSection);
    }

}
