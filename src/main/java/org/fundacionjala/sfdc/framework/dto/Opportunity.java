package org.fundacionjala.sfdc.framework.dto;

import org.fundacionjala.sfdc.framework.utils.JSONMapper;

/**
 * @author jimmy vargas
 * @since 6/22/2015.
 */
public class Opportunity {
    String file;
    JSONMapper jsonMapper;

    public boolean privateChk;
    public String opportunityName;
    public String accountName;
    public String accountNameLookup;
    public String type;
    public String leadSource;
    public String amount;
    public String closeDate;
    public String nextStep;
    public String stage;
    public String probability;
    public String primaryCampaignSource;
    public String primaryCampaignSourceLookUp;

    /*Additional Information*/
    public String orderNumber;
    public String currentGenerator;
    public String trackingNumber;
    public String mainCompetitors;
    public String deliveryStatus;

    /*description*/
    public String description;

    public Opportunity(){

    }


}
