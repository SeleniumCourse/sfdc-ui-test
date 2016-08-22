package org.fundacionjala.sfdc.framework.soap;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.apache.log4j.Logger;

import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * class to connect by API to sales force.
 *
 * @author Veronica Prado
 * @author DanielGonzales
 */
public class APIConnector {

    private static final Logger LOGGER = Logger.getLogger(APIConnector.class.getName());

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static APIConnector instance;

    private PartnerConnection connection;

    private APIConnector() {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(ENVIRONMENT.getPrimaryUser());
        config.setPassword(ENVIRONMENT.getPrimaryUserPasswordToken());
        config.setAuthEndpoint(ENVIRONMENT.getUrlApi());
        config.setServiceEndpoint(ENVIRONMENT.getUrlApi());
        if (ENVIRONMENT.getProxyHost() != null && ENVIRONMENT.getProxyPort() != null) {
            config.setProxy(ENVIRONMENT.getProxyHost(), Integer.valueOf(ENVIRONMENT.getProxyPort()));
        }
        try {
            connection = Connector.newConnection(config);
        } catch (ConnectionException e) {
            LOGGER.error("Error on Connect to Api :", e);
        }
    }

    public static APIConnector getInstance() {
        if (instance == null) {
            instance = new APIConnector();
        }
        return instance;
    }

    public PartnerConnection getConnection() {
        return this.connection;
    }
}
