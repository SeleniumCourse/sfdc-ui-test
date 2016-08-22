package org.fundacionjala.sfdc.pages.campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.HomeBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represents Campaing Home page
 *
 * @author Marcelo.Vargas
 */
public class CampaignsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Campaigns:')]")
    private WebElement campaignSection;

    @Override
    public CampaignForm clickNewBtn() {
        clickNewButton();
        return new CampaignForm();
    }

    @Override
    public CampaignView clickNewViewLnk() {
        clickNewViewLink();
        return new CampaignView();
    }

    @Override
    public CampaignView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new CampaignView();
    }

    @Override
    public CampaignDetail selectRecentItem(String campaign) {
        super.clickRecentItem(campaign);
        return new CampaignDetail();
    }

    @Override
    public CampaignsHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public boolean isUserInCampaignsTab() {
        return isWebElementVisible(campaignSection);
    }
}
