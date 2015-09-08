package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.FieldToDisplayView;
import com.salesforce.dev.framework.Objects.FilterView;
import com.salesforce.dev.framework.Objects.Product;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Product.ProductDetails;
import com.salesforce.dev.pages.Product.ProductView;
import com.salesforce.dev.pages.Product.ProductViewDetail;
import com.salesforce.dev.pages.Product.ProductsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Melby Arguedas on 9/7/2015.
 */
public class CreateProductViewFiltersFieldsAdded {

    private ProductsHome productsHome;
    private ProductDetails productDetail;
    private ProductView productView;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private ProductViewDetail productViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateProductViewFiltersFieldAdded.json");
    }


    @Test(groups = {"Regression"}, dataProvider = "dataDriven")
    public void testCreateProductViewWithFilters(ViewSalesForce viewSalesForce) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productView = productsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        List<FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for(FilterView addFilter: additionalField){
            productView = productView.addAdditionalFiltersByField(count,addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(),addFilter.getValueFilter());
            count++;
        }
        List <FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for(FieldToDisplayView fields:fieldToDisplayViews)
            productView = productView.addNewFieldToDisplay(fields.getFieldToDisplay());
        productViewDetail = productView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Product view was created");
        Assert.assertTrue(productViewDetail.validateNameView(viewSalesForce.getViewName()));
        //validateFieldsAdded
        for(FieldToDisplayView fields:fieldToDisplayViews){
            Assert.assertTrue(productViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Regression"})
    public void tearDown() {
        productViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Product View was deleted");
    }
}


