package org.fundacionjala.sfdc.pages.product;

/**
 * This class will be used to build a Product.
 *
 * @author Monica
 */
public class ProductBuilder {

    private String prodName;

    private String prodCode;

    private String prodDesc;

    private boolean activeProduct;

    public ProductBuilder(String prodName) {
        this.prodName = prodName;
    }

    public String getProductName() {
        return prodName;
    }

    public ProductBuilder setProductName(String prodName) {
        this.prodName = prodName;
        return this;
    }

    public String getProductDesc() {
        return prodDesc;
    }

    public ProductBuilder setProductDesc(String prodDesc) {
        this.prodDesc = prodDesc;
        return this;
    }

    public String getProductCode() {
        return prodCode;
    }

    public ProductBuilder setProductCode(String prodCode) {
        this.prodCode = prodCode;
        return this;
    }

    public Boolean getProductActive() {
        return activeProduct;
    }

    public ProductBuilder setProductActive(Boolean activeProduct) {
        this.activeProduct = activeProduct;
        return this;
    }

    public ProductForm build() {
        return new ProductForm(this);
    }
}
