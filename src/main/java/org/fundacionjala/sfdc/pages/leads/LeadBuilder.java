package org.fundacionjala.sfdc.pages.leads;

/**
 * This class will be used to build a Lead.
 *
 * @author Jimmy Vargas
 */
public class LeadBuilder {

    /*attributes for the lead information*/
    protected String salutation;

    protected String firstName;

    protected String lastName;

    protected String company;

    protected String title;

    protected String leadSource;

    protected String campaign;

    protected String industry;

    protected String annualRevenue;

    protected String phone;

    protected String mobile;

    protected String fax;

    protected String email;

    protected String website;

    protected String leadStatus;

    protected String rating;

    protected String numEmployees;

    /*attributes for the address information*/
    protected String street;

    protected String city;

    protected String stateProvince;

    protected String zipPostalCode;

    protected String country;

    /*attributes for the additional information*/
    protected String productInterest;

    protected String sicCode;

    protected String currentGenerators;

    protected String primary;

    protected String numberLocations;

    /*description information*/
    protected String description;

    /*optional*/
    protected boolean asignRule;

    public LeadBuilder(String lastName, String company, String leadStatus){
        this.lastName = lastName;
        this.company = company;
        this.leadStatus = leadStatus;
    }

    /*attributes for the lead information*/
    public LeadBuilder setSalutation(String salutation){
        this.salutation = salutation;
        return this;
    }
    public LeadBuilder setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public LeadBuilder setTitle(String title){
        this.title = title;
        return this;
    }
    public LeadBuilder setLeadSource(String leadSource){
        this.leadSource = leadSource;
        return this;
    }

    public LeadBuilder setCampaign(String campaign){
        this.campaign = campaign;
        return this;
    }

    public LeadBuilder setIndustry(String industry){
        this.industry = industry;
        return this;
    }

    public LeadBuilder setAnnualRevenue(String annualRevenue){
        this.annualRevenue = annualRevenue;
        return  this;
    }

    public LeadBuilder setPhone(String phone){
        this.phone = phone;
        return  this;
    }

    public LeadBuilder setMobile(String mobile){
        this.mobile = mobile;
        return this;
    }

    public LeadBuilder setFax(String fax){
        this.fax = fax;
        return this;
    }

    public LeadBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public LeadBuilder setWebsite(String website){
        this.website = website;
        return  this;
    }

    public LeadBuilder setLeadStatus(String leadStatus){
        this.leadStatus = leadStatus;
        return this;
    }

    public LeadBuilder setRating(String rating){
        this.rating = rating;
        return this;
    }

    public LeadBuilder setNumEmployees(String numEmployees){
        this.numEmployees = numEmployees;
        return this;
    }

    public LeadBuilder setStreet(String street){
        this.street = street;
        return this;
    }

    public LeadBuilder setCity(String city){
        this.city = city;
        return this;
    }
    public LeadBuilder setStateProvince(String stateProvince){
        this.stateProvince = stateProvince;
        return this;
    }

    public LeadBuilder setZipPostalCode(String zipPostalCode){
        this.zipPostalCode = zipPostalCode;
        return this;
    }
    public LeadBuilder setCountry(String country){
        this.country = country;
        return this;
    }

    public LeadBuilder setProductInterest(String productInterest){
        this.productInterest = productInterest;
        return this;
    }

    public LeadBuilder setSicCode(String sicCode){
        this.sicCode = sicCode;
        return this;
    }

    public LeadBuilder setCurrentGenerators(String currentGenerators){
        this.currentGenerators = currentGenerators;
        return this;
    }

    public LeadBuilder setPrimary(String primary){
        this.primary = primary;
        return this;
    }

    public LeadBuilder setNumberLocations(String numberLocations){
        this.numberLocations = numberLocations;
        return this;
    }

    public LeadBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public LeadBuilder setAsignRule(boolean asignRule){
        this.asignRule = asignRule;
        return this;
    }

    public LeadForm build(){
        return new LeadForm(this);
    }
}
