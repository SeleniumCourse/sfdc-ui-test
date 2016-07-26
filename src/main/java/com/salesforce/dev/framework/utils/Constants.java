package com.salesforce.dev.framework.utils;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.LoggerManager;

/**
 * Created by brunobarrios on 7/26/2016.
 */
public class Constants {
    public static final LoggerManager LOGGER_MANAGER = LoggerManager.getInstance();

    public static final Environment ENVIRONMENT = Environment.getInstance();
    private Constants(){}
}
