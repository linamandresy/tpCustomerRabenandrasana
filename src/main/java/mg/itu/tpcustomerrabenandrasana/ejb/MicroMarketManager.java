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
import mg.itu.tpcustomerrabenandrasana.entity.MicroMarket;

/**
 *
 * @author mandr
 */
@Stateless
public class MicroMarketManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<MicroMarket> getAllMicroMarket(){
        Query query =em.createNamedQuery("MicroMarket.findAll");
        return query.getResultList();
    }
    public MicroMarket findById(String zipCode){
        return em.find(MicroMarket.class, zipCode);
    }
    public void persist(MicroMarket microMarket){
        em.persist(microMarket);
    }
}
