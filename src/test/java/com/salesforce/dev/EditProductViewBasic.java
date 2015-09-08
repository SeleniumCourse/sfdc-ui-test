package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.Opportunity;
import com.salesforce.dev.framework.Objects.Product;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Common;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Product.ProductView;
import com.salesforce.dev.pages.Product.ProductViewDetail;
import com.salesforce.dev.pages.Product.ProductsHome;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * Created by Melby Arguedas on 9/7/2015.
 */
public class EditProductViewBasic {
    private HomePage homePage;
    private ProductsHome productsHome;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private ProductView productView;
    private String nameView;
    private ProductViewDetail productViewDetail;
    Product oppPro;


    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("EditProductViewBasic.json");
    }
    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();


        oppPro = JSONMapper.getProduct();
        // creating the product base
        Common.createProduct(oppPro);
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditProduct(ViewSalesForce viewSalesForceUpdate) {
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productView = productsHome.clickEditViewLnk(nameView)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        productViewDetail = productView.clickSaveBtn();
        Assert.assertTrue(productViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Product View has been updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        productViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Product View was deleted");
    }

}
