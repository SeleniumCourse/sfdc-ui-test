package org.fundacionjala.sfdc.pages.leads;

import org.apache.log4j.Logger;

import org.fundacionjala.sfdc.framework.selenium.CommonOperation;
import org.fundacionjala.sfdc.pages.base.ViewBase;

/**
 * This class will be used to represent Lead view and its options.
 *
 * @author Ariel Mattos
 */
public class LeadView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(LeadView.class.getName());

    public LeadView() {
        CommonOperation.waitForWebElement(saveBtn);
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public LeadView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public LeadView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
    public LeadView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public LeadView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public LeadView checkFilterByOwner(String filter) {
        if (filter.compareToIgnoreCase("All Unconverted leads") == 0)
            checkFilterOwnerAll();
        else
            checkFilterOwnerMy();
        return this;
    }

    @Override
    public LeadView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public LeadView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public LeadView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public LeadViewDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Basic leads View was created");
        return new LeadViewDetail();
    }
}
