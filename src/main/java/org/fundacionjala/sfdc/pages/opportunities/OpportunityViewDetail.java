package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class will be used to represent Opportunities view details.
 *
 * @author Carlos Orellana
 */
public class OpportunityViewDetail extends ViewDetailBase {

    public OpportunityViewDetail() {
        waitForWebElement(viewSelected);
    }

    @Override
    protected OpportunityView clickEditLnk() {
        clickEditLink();
        return new OpportunityView();
    }

    @Override
    public OpportunityViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}
