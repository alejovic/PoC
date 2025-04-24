package com.avg.javaee9;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProductBean implements Serializable {

    @Inject
    private ProductEJB productEJB;

    private List<Product> products;
    private Product selectedProduct;
    private Product newProduct;

    @PostConstruct
    public void init() {
        products = productEJB.findAll();
        newProduct = new Product();
    }

    public void loadProducts() {
        products = productEJB.findAll();
    }

    public String saveProduct() {
        try {
            if (newProduct.getId() == null) {
                productEJB.create(newProduct);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product created"));
            } else {
                productEJB.update(newProduct);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product updated"));
            }
            loadProducts();
            newProduct = new Product();
            return "product-list?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            return null;
        }
    }

    public void deleteProduct(Long id) {
        try {
            productEJB.delete(id);
            loadProducts();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product deleted"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    public void prepareNewProduct() {
        newProduct = new Product();
    }

    public void prepareEditProduct(Product product) {
        newProduct = new Product();
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
    }

    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
}