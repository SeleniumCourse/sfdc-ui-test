package org.fundacionjala.sfdc.framework.soap;

import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;

/**
 * Class to get data related to Campaign
 *
 * @author Veronica Prado
 */
public final class CampaignGenie {

    private static final Logger LOGGER = Logger.getLogger(CampaignGenie.class.getName());

    private CampaignGenie() {
    }

    public static void createParentCampaign(String nameCampaign) {
        PartnerConnection connection = APIConnector.getInstance().getConnection();
        SObject objectSales = new SObject();
        objectSales.setType("Campaign");
        objectSales.setField("Name", nameCampaign);
        objectSales.setField("IsActive", true);
        try {
            connection.create(new SObject[]{objectSales});
        } catch (ConnectionException e) {
            LOGGER.error("Error on Create parent campaign by Api :", e);
        }
    }
}
