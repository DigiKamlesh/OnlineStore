package com.onlinestore.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
        )
public class ProductsModel {
    private static final Logger logs = LoggerFactory.getLogger(ProductsModel.class);


//    Mapping Values
@Inject
Resource resource;
    @ValueMapValue
    private String productName;
    @ValueMapValue
    private String brandName;
    @ValueMapValue
    private int quantity;
    @ValueMapValue
    private Date mfgDate;
    @ValueMapValue
    private Date expDate;
    @ValueMapValue
    private int price;

    @ValueMapValue
    private String similarBrandBrandName;
    private Date similarBrandMfgDate;
    @ValueMapValue
    private Date similarBrandExpDate;
    @ValueMapValue
    private int similarBrandPrice;

// Implementation Logic for getting Products


    public List<Map<String, Object>> getProductDetails() {
        List<Map<String, Object>> productDetailsList=new ArrayList<>();
        try {
            Resource productDetail=resource.getChild("productDetails");
            if(productDetail!=null){
                for (Resource products : productDetail.getChildren()) {
                    Map<String,Object> product=new HashMap<>();
                    product.put("productName",products.getValueMap().get("productName",String.class));
                    product.put("brandName",products.getValueMap().get("brandName",String.class));
                    product.put("quantity",products.getValueMap().get("quantity",String.class));
                    product.put("mfgDate",products.getValueMap().get("mfgDate",Date.class));
                    product.put("expDate",products.getValueMap().get("expDate",Date.class));
                    product.put("price",products.getValueMap().get("price",Integer.class));

                    productDetailsList.add(product);
                }
            }
        }catch (Exception e){
            logs.info("\n ERROR while getting Product Details {} ",e.getMessage());
        }
            return productDetailsList;
    }

//    Implentation for Similar Brands

    public List<Map<String, Object>> getSimilarBrands() {
        List<Map<String, Object>> similarBrandsProductDetailsList=new ArrayList<>();
        try {
            Resource similarBrand=resource.getChild("similarBrands");
            if(similarBrand!=null){
                for (Resource products : similarBrand.getChildren()) {
                    Map<String,Object> similarBrandsProduct=new HashMap<>();
                    similarBrandsProduct.put("similarBrandBrandName",products.getValueMap().get("similarBrandBrandName",String.class));
                    similarBrandsProduct.put("similarBrandMfgDate",products.getValueMap().get("similarBrandMfgDate",Date.class));
                    similarBrandsProduct.put("similarBrandExpDate",products.getValueMap().get("similarBrandExpDate",Date.class));
                    similarBrandsProduct.put("similarBrandPrice",products.getValueMap().get("similarBrandPrice",Integer.class));

                    similarBrandsProductDetailsList.add(similarBrandsProduct);
                }
            }
        }catch (Exception e){
            logs.info("\n ERROR while getting Similar Brand Product Details {} ",e.getMessage());
        }
        return similarBrandsProductDetailsList;
    }



// Getter methods
    public String getProductName() {
        logs.info("from product name");
        return productName;
    }

    public String getBrandName() {
        logs.info("from Brand name");
        return brandName;
    }

    public int getQuantity() {
        logs.info("from Quantity");
        return quantity;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public int getPrice() {
        return price;
    }

    public String getSimilarBrandBrandName() {
        logs.info("from Similar Brand name");

        return similarBrandBrandName;
    }

    public Date getSimilarBrandMfgDate() {
        return similarBrandMfgDate;
    }

    public Date getSimilarBrandExpDate() {
        return similarBrandExpDate;
    }

    public int getSimilarBrandPrice() {
        logs.info("from Similar Brand Price");
        return similarBrandPrice;
    }
}
