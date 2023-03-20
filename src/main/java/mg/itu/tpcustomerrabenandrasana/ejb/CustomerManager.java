/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerrabenandrasana.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tpcustomerrabenandrasana.entity.Customer;

/**
 * Gestion des operation de base de donnée de la classe customer
 * @author mandr
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<Customer> getAllCustomers(){
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    public Customer update(Customer customer){
        return em.merge(customer);
    }
    
    public void persist(Customer customer){
        em.persist(customer);
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class,idCustomer);
    }
}
