package com.salesforce.dev.framework;

/**
 * Created by Walter Mercado on 6/22/2015.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.dev.framework.Objects.Account;
import com.salesforce.dev.framework.Objects.Campaign;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataDrivenManager {
    private JSONParser parser;

    public DataDrivenManager(){
    }

    public Iterator<Account[]> getAccountsDD(){

        Collection<Account[]> accountsArray =new ArrayList<Account[]>();
        try {
            parser = new JSONParser();
            Object jsonObject = parser.parse(new FileReader("src/test/resources/AccountsBaseDD.json"));
            JSONArray jsonArray = (JSONArray) jsonObject;

            ObjectMapper objectMapper = new ObjectMapper();

            List<Account> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Account.class));

            for (int i = 0 ; i< navigation.size(); i++){
                Account account = (Account)navigation.get(i);
                accountsArray.add(new Account[]{account});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return accountsArray.iterator();
    }

    public Iterator<ViewSalesForce[]> getDataView(String fileJson){

        Collection<ViewSalesForce[]> viewSalesForcesArray =new ArrayList<ViewSalesForce[]>();
        try {
            parser = new JSONParser();
            String pathFileJson = "src/test/resources/" + fileJson;
            Object jsonObject = parser.parse(new FileReader(pathFileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;

            ObjectMapper objectMapper = new ObjectMapper();

            List<ViewSalesForce> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, ViewSalesForce.class));

                        for (ViewSalesForce view : navigation) {
                viewSalesForcesArray.add(new ViewSalesForce[]{view});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(), "Error on data view from Json file:", e);
        } catch (ParseException e) {
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(), "Error on data view from Json file:", e);
        }
        return viewSalesForcesArray.iterator();
    }


    public Iterator<Campaign[]> getCampaign(String fileJson) {

        Collection<Campaign[]> campaignsArray = new ArrayList<Campaign[]>();
        try {
            parser = new JSONParser();
            Object jsonObject = parser.parse(new FileReader("src/test/resources/" + fileJson));
            JSONArray jsonArray = (JSONArray) jsonObject;

            ObjectMapper objectMapper = new ObjectMapper();

            List<Campaign> navigation = objectMapper.readValue(jsonArray.toJSONString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Campaign.class));

            for (int i = 0; i < navigation.size(); i++) {
                Campaign campaign = (Campaign) navigation.get(i);
                campaignsArray.add(new Campaign[]{campaign});
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(), "Error on data for Campaign from Json file:", e);
        } catch (ParseException e) {
            LoggerManager.getInstance().addErrorLog(this.getClass().getName(), "Error on data for Campaign from Json file:", e);
        }
        return campaignsArray.iterator();
    }
}
