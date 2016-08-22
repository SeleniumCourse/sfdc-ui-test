package org.fundacionjala.sfdc.pages.campaigns;

import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class will be used to represent Campaing view details and its options.
 *
 * @author Veronica
 */
public class CampaignViewDetail extends ViewDetailBase {

    public CampaignViewDetail() {
        waitForWebElement(viewSelected);
    }

    @Override
    protected CampaignView clickEditLnk() {
        clickEditLink();
        return new CampaignView();
    }

    @Override
    public CampaignViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}
