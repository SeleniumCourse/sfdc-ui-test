package org.fundacionjala.sfdc.framework.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import static org.fundacionjala.sfdc.framework.utils.Constants.JSON_RESOURCES;

/**
 * @author jimmy vargas.
 * @author Mijhail Villarroel
 */
public class JSONMapper {

    private static final Logger LOGGER = Logger.getLogger(JSONMapper.class.getSimpleName());

    private JSONMapper() {
    }

    /**
     * Return T generic any class
     *
     * @param elementClass
     * @param nameJson     Path of a json.
     * @return
     */
    public static <T> T getGeneric(Class<T> elementClass, String nameJson) {
        final String pathFileJson = JSON_RESOURCES.concat(nameJson);
        Object result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(new File(pathFileJson), elementClass);
        } catch (IOException e) {
            LOGGER.warn("File not found", e);
        }
        return (T) result;
    }

}
