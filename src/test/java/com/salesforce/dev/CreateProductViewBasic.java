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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Melby Arguedas on 9/7/2015.
 */
public class CreateProductViewBasic {

    private ProductsHome productsHome;
    private ProductView productView;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private ProductViewDetail productViewDetail;

   @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateProductViewBasic.json");
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateProductView(ViewSalesForce viewSalesForce) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productView = productsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        productViewDetail = productView.clickSaveBtn();
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Product was created");
        Assert.assertTrue(productViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

}
