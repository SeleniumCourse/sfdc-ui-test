package org.fundacionjala.sfdc.framework.dto;

/**
 * @author veronica
 * @since 8/21/2015.
 */
public class FilterView {

    private String fieldFilter;

    private String operatorFilter;

    private String valueFilter;

    public String getFieldFilter() {
        return fieldFilter;
    }

    public String getOperatorFilter() {
        return operatorFilter;
    }

    public String getValueFilter() {
        return valueFilter;
    }

    public void setFieldFilter(String fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public void setOperatorFilter(String operatorFilter) {
        this.operatorFilter = operatorFilter;
    }

    public void setValueFilter(String valueFilter){
        this.valueFilter = valueFilter;
    }
}
