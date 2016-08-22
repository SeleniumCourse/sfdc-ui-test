package org.fundacionjala.sfdc.framework.dto;

import java.util.List;

/**
 * @author veronica
 * @since 8/21/2015.
 */
public class ViewSalesForce {

    private String viewName;

    private String uniqueViewName;

    private String filterByOwner;

    private String filterByCampaign;

    private List<FilterView> additionalFields;

    private List<FieldToDisplayView> fieldsDisplay;

    private String restrictVisibility;

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setFilterByOwner(String filterByOwner) {
        this.filterByOwner = filterByOwner;
    }

    public void setUniqueViewName(String uniqueViewName) {
        this.uniqueViewName = uniqueViewName;
    }

    public void setAdditionalFields(List<FilterView> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public void setFieldsDisplay(List<FieldToDisplayView> fieldsDisplay) {
        this.fieldsDisplay = fieldsDisplay;
    }

    public void setRestrictVisibility(String restrictVisibility) {
        this.restrictVisibility = restrictVisibility;
    }

    public void setFilterByCampaign(String filterByCampaign) {
        this.filterByCampaign = filterByCampaign;
    }

    public List<FilterView> getAdditionalFields() {
        return additionalFields;
    }

    public String getFilterByOwner() {
        return filterByOwner;
    }

    public String getFilterByCampaign(){return filterByCampaign;}

    public String getViewName() {
        return viewName;
    }

    public String getUniqueViewName() {
        return uniqueViewName;
    }

    public List<FieldToDisplayView> getFieldsDisplay() {
        return fieldsDisplay;
    }

    public String getRestrictVisibility() {
        return restrictVisibility;
    }
}
