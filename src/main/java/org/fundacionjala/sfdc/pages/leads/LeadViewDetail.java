package org.fundacionjala.sfdc.pages.leads;

import org.apache.log4j.Logger;

import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.waitForWebElement;

/**
 * @author Ariel Mattos.
 */
public class LeadViewDetail extends ViewDetailBase {

    private static final Logger LOGGER = Logger.getLogger(LeadViewDetail.class.getName());

    public LeadViewDetail() {
        waitForWebElement(viewSelected);
    }

    @Override
    protected LeadView clickEditLnk() {
        clickEditLink();
        return new LeadView();
    }

    @Override
    public LeadViewDetail clickDeleteLnk() {
        clickDeleteLink();
        LOGGER.info("Lead View was deleted");
        return this;
    }
}
