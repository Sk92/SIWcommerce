package facades;

import model.Provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele on 08/06/2015.
 */

@Stateless(name="providerFacade")
public class ProviderFacade {

    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;

    public Provider createProvider(String vat, String phoneNumber,String email,String address){
        Provider provider = new Provider();
        provider.setVat(vat);
        provider.setPhoneNumber(phoneNumber);
        provider.setEmail(email);
        provider.setAddress(address);
        em.persist(provider);
        return provider;

    }
    /* public List<Product> getProviderList() {
        return em.createNamedQuery("Provider.getAllProvider", Provider.class).getResultList();
    }*/

}
