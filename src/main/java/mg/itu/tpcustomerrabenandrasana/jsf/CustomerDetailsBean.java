/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomerrabenandrasana.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpcustomerrabenandrasana.ejb.CustomerManager;
import mg.itu.tpcustomerrabenandrasana.ejb.DiscountManager;
import mg.itu.tpcustomerrabenandrasana.ejb.MicroMarketManager;

import mg.itu.tpcustomerrabenandrasana.entity.Customer;
import mg.itu.tpcustomerrabenandrasana.entity.Discount;
import mg.itu.tpcustomerrabenandrasana.entity.MicroMarket;

/**
 *
 * @author mandr
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;
    @EJB
    private DiscountManager discountManager;
    @EJB 
    private MicroMarketManager microMarketManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    /**
     * Retourne la liste de tous les discount
     */
    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }

    /**
     * Retourne la liste de tous les micro markets
     * @return 
     */
    public List<MicroMarket> getMicroMarkets(){
        return microMarketManager.getAllMicroMarket();
    }
    /**
     * Creates a new instance of CustomerDetailsBean
     */
    public CustomerDetailsBean() {
    }

}
