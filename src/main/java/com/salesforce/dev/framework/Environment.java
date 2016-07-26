package com.salesforce.dev.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Carlos Gonzales on 6/8/2015.
 */
public class Environment {

    private static final String PRIMARY_USER_NAME = "primaryUserName";

    private static final String PRIMARY_USER_PASSWORD = "primaryUserPassword";

    private static final String BROWSER = "browser";

    private static final String GROUPS = "groups";

    private static final String DISPLAY_NAME = "displayName";

    private static final String MODE = "mode";

    private static final String USER_NAME = "userName";

    private static final String KEY = "key";

    private static final String PRIMARY_USE_PASSWORD_TOKEN = "primaryUsePasswordToken";

    private static final String URL_API = "urlApi";

    private static final String BROWSER_REMOTE = "browserRemote";

    private static final String PLATFORM_REMOTE = "platformRemote";

    private static final String VERSION_REMOTE = "versionRemote";

    private static Environment environment;
    private Properties properties;

    private Environment() {
        readFile();
    }

    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    public void readFile() {
        File file = new File("gradle.properties");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties = new Properties();
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnv(String key) {
        String env = System.getProperty(key);
        if (env == null) {
            env = properties.getProperty(key);
        }
        return env;
    }

    public String getPrimaryUser() {
        return getEnv(PRIMARY_USER_NAME);
    }

    public String getPrimaryPassword() {
        return getEnv(PRIMARY_USER_PASSWORD);
    }

    public String getBrowser() {
        return getEnv(BROWSER);
    }

    public String getGroups() {
        return getEnv(GROUPS);
    }

    public String getDisplayName() {
        return getEnv(DISPLAY_NAME);
    }

    public String getMode() {
        return getEnv(MODE);
    }

    public String getUserName() {
        return getEnv(USER_NAME);
    }

    public String getKey() {
        return getEnv(KEY);
    }

    public String getPrimaryUserPasswordToken() {
        return getEnv(PRIMARY_USE_PASSWORD_TOKEN);
    }

    public String getUrlApi() {
        return getEnv(URL_API);
    }

    public String getBrowserRemote() {
        return getEnv(BROWSER_REMOTE);
    }

    public String getPlatformRemote() {
        return getEnv(PLATFORM_REMOTE);
    }

    public String getVersionRemote() {
        return getEnv(VERSION_REMOTE);
    }

}
