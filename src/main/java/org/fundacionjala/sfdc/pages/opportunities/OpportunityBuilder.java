package org.fundacionjala.sfdc.pages.opportunities;

/**
 * This class will be used to build an opportunity
 *
 * @author Jimmy Vargas
 */
public class OpportunityBuilder {

    protected String opName;

    protected String accountName;

    protected String type;

    protected boolean isPrivate;

    protected String leadSource;

    protected String orderNumber;

    protected String currentGenerator;

    protected String trackingNumber;

    protected String opDescription;

    protected String amount;

    protected String expectedRevenue;

    protected String closeDate;

    protected String nextStep;

    protected String stage;

    protected String probability;

    protected String primaryCampaignSource;

    protected String mainCompetidors;

    protected String deliveryInstallationStatus;


    public OpportunityBuilder(String opportunityName, String closeDate, String stage) {
        this.opName = opportunityName;
        this.closeDate = closeDate;
        this.stage = stage;
    }

    public OpportunityBuilder setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public OpportunityBuilder setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public OpportunityBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public OpportunityBuilder setLeadSource(String leadSource) {
        this.leadSource = leadSource;
        return this;
    }

    public OpportunityBuilder setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public OpportunityBuilder setCurrentGenerator(String currentGenerator) {
        this.currentGenerator = currentGenerator;
        return this;
    }

    public OpportunityBuilder setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public OpportunityBuilder setOpDescription(String opDescription) {
        this.opDescription = opDescription;
        return this;
    }

    public OpportunityBuilder setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public OpportunityBuilder setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
        return this;
    }

    public OpportunityBuilder setNextStep(String nextStep) {
        this.nextStep = nextStep;
        return this;
    }

    public OpportunityBuilder setProbability(String probability) {
        this.probability = probability;
        return this;
    }

    public OpportunityBuilder setPrimaryCampaignSource(String primaryCampaignSource) {
        this.primaryCampaignSource = primaryCampaignSource;
        return this;
    }

    public OpportunityBuilder setMainCompetitors(String mainCompetitors) {
        this.mainCompetidors = mainCompetitors;
        return this;
    }

    public OpportunityBuilder setDeliveryInstallationStatus(String deliveryInsallationStatus) {
        this.deliveryInstallationStatus = deliveryInsallationStatus;
        return this;
    }

    public OpportunityForm build() {
        return new OpportunityForm(this);
    }

}
