package com.avg.javaee9;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Transactional
    public void create(Product product) {
        em.persist(product);
    }

    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    @Transactional
    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }
}