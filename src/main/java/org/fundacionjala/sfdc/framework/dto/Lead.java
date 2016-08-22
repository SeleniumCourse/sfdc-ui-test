package org.fundacionjala.sfdc.framework.dto;

import org.fundacionjala.sfdc.framework.utils.JSONMapper;

/**
 * @author jimmy vargas
 * @since 6/24/2015.
 */
public class Lead {

    String file;

    JSONMapper jsonMapper;

    /*Lead Information*/
    private String nameSalutation;
    private String firstName;
    private String lastName;
    private String company;
    private String title;
    private String leadSource;
    private String campaign;
    private String campaignLookup;
    private String industry;
    private String annualRevenue;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private String website;
    private String leadStatus;
    private String rating;
    private String numEmployees;

    /*Address Information*/
    private String street;
    private String city;
    private String stateProvince;
    private String zipCode;
    private String country;

    /*additional information*/
    private String productInterest;
    private String sicCode;
    private String numberLocations;
    private String currentGenerators;
    private String primary;

    /*Others*/
    private String description;
    private String assignRule;

    public String getCompany() {
        return company;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public String getFile() {
        return file;
    }

    public JSONMapper getJsonMapper() {
        return jsonMapper;
    }

    public String getNameSalutation() {
        return nameSalutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getCampaign() {
        return campaign;
    }

    public String getCampaignLookup() {
        return campaignLookup;
    }

    public String getIndustry() {
        return industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getRating() {
        return rating;
    }

    public String getNumEmployees() {
        return numEmployees;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getProductInterest() {
        return productInterest;
    }

    public String getSicCode() {
        return sicCode;
    }

    public String getNumberLocations() {
        return numberLocations;
    }

    public String getCurrentGenerators() {
        return currentGenerators;
    }

    public String getPrimary() {
        return primary;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignRule() {
        return assignRule;
    }
}
