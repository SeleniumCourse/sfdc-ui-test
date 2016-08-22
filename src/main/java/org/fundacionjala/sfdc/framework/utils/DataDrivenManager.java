package org.fundacionjala.sfdc.framework.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static org.fundacionjala.sfdc.framework.utils.Constants.JSON_RESOURCES;

/**
 * 
 * @author Walter Mercado
 * @author DanielGonzales
 */
public final class DataDrivenManager {
    private static final Logger LOGGER = Logger.getLogger(DataDrivenManager.class.getName());

    private DataDrivenManager() {
    }

    public static Iterator<Object[]> getObjects(String nameJson, Class<?> elementClass) {
        List<Object[]> objectsArray = new ArrayList<>();

        final String pathFileJson = JSON_RESOURCES.concat(nameJson);
        try (FileReader fileReader = new FileReader(pathFileJson)) {
            Object jsonObject = new JSONParser().parse(fileReader);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Object> objectList = objectMapper.readValue(((JSONArray) jsonObject).toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass));

            for (Object object : objectList) {
                objectsArray.add(new Object[]{object});
            }
        } catch (IOException | ParseException e) {
            LOGGER.warn("Json fails", e);
        }
        return objectsArray.iterator();
    }

}
