/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.GastoExtra;

/**
 *
 * @author 631410038
 */
@Stateless
public class GastoExtraFacade extends AbstractFacade<GastoExtra> {

    @PersistenceContext(unitName = "OrganicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GastoExtraFacade() {
        super(GastoExtra.class);
    }
    
}
