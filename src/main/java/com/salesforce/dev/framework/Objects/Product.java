package com.salesforce.dev.framework.Objects;

/**
 * Created by Melby Arguedas on 9/06/2015.
 */
public class Product {
    public String productName;
    public String productCode;
    public String productDescription;

    public Product(){}

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

}
