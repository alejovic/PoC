package com.avg.javaee9;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductEJB {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public void create(Product product) {
        em.persist(product);
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }
}
