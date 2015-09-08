package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.Product;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Product.ProductDetails;
import com.salesforce.dev.pages.Product.ProductForm;
import com.salesforce.dev.pages.Product.ProductsHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.salesforce.dev.pages.Product.ProductBuilder;

import java.util.Iterator;

/**
 * Created by Monica Pardo on 6/13/2015.
 *
 */
public class CreateProduct {

    HomePage homePage;
    MainPage mainPage;
    NavigationBar navigationBar;
    private ProductsHome productsHome;
    private ProductForm productForm;
    private ProductDetails productDetails;

    @DataProvider(name = "dataDriven")
    public Iterator<Product[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getProduct("CreateProduct.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateProduct(Product product) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productForm = productsHome.clickNewBtn();
        productForm = new ProductBuilder(product.productName,product.productCode,product.productDescription)
                .setProductName(product.productName)
                .setProductCode(product.productCode)
                .setProductDesc(product.productDescription)
                .setProductActive(true).build();
        productDetails = productForm.saveProduct();
        Assert.assertTrue(productDetails.VerifyProduct(product.productName), "product Was not Created");

    }

}


