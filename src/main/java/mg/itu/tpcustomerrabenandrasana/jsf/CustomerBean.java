/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomerrabenandrasana.jsf;


import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpcustomerrabenandrasana.Customer;
import mg.itu.tpcustomerrabenandrasana.ejb.CustomerManager;

/**
 *
 * @author mandr
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    private List<Customer> customerList;
    
    @EJB
    private CustomerManager customerManager;
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    /**
     * 
     * @return la  liste des clients por affichage dans une datatable
     */
    public List<Customer> getCustomers(){
        if(customerList==null){
            customerList=customerManager.getAllCustomers();
        }
        return customerList;
    }
    
}
