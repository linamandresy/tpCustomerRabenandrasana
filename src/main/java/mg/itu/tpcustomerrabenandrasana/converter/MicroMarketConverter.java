/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerrabenandrasana.converter;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mg.itu.tpcustomerrabenandrasana.ejb.MicroMarketManager;
import mg.itu.tpcustomerrabenandrasana.entity.MicroMarket;

/**
 *
 * @author mandr
 */
@FacesConverter(value="microMarketConverter",managed=true)
public class MicroMarketConverter implements Converter<MicroMarket>{

    @EJB
    private MicroMarketManager microMarketManager;
    
    @Override
    public MicroMarket getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null) return null;
        return microMarketManager.findById(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, MicroMarket microMarket) {
        if(microMarket==null) return "";
        return microMarket.getZipCode();
    }
    
}
