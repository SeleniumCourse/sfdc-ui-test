package org.fundacionjala.sfdc.accounts;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.FieldToDisplayView;
import org.fundacionjala.sfdc.framework.dto.ViewSalesForce;
import org.fundacionjala.sfdc.framework.utils.DataDrivenManager;
import org.fundacionjala.sfdc.framework.utils.RandomGenerator;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.accounts.AccountView;
import org.fundacionjala.sfdc.pages.accounts.AccountsHome;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the filters view of the creation of an account.
 *
 * @author Carlos Orellana
 * @author Mijhail Villarroel
 */
public class CreateAccountViewFiltersFieldsAdded {

    private AccountsHome accountsHome;

    private AccountView accountView;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private ViewDetailBase accountViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<Object[]> getValues() {
        return DataDrivenManager.getObjects("CreateAccountsViewFiltersFieldAdded.json", ViewSalesForce.class);
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaignViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountView = accountsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName() + RandomGenerator.getInstance().getRandomString())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        accountView.addFilter(viewSalesForce.getAdditionalFields());
        List<FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        accountView.addAccountView(fieldToDisplayViews);
        accountViewDetail = accountView.clickSaveBtn();
        assertEquals(accountViewDetail.getViewSelected(), viewSalesForce.getViewName());
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            Assert.assertTrue(accountViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountViewDetail.clickDeleteLnk();
    }
}
