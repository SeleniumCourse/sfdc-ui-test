package org.fundacionjala.sfdc.pages.opportunities;

import org.apache.log4j.Logger;

import org.fundacionjala.sfdc.pages.base.ViewBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class represents opportunity view.
 *
 * @author Carlos Orellana.
 */
public class OpportunityView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(OpportunityView.class.getName());

    public OpportunityView() {
        waitForWebElement(saveBtn);
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public OpportunityView setViewName(String viewName) {
        setViewNameFld(viewName);
        return this;
    }

    @Override
    public OpportunityView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName);
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    @Override
    public OpportunityView checkFilterByOwner(String filter) {
        if (filter.compareToIgnoreCase("All opportunities") == 0)
            checkFilterOwnerAll();
        else
            checkFilterOwnerMy();
        return this;
    }

    @Override
    public OpportunityView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public OpportunityView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public OpportunityView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public OpportunityViewDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Opportunity was created");
        return new OpportunityViewDetail();
    }
}
