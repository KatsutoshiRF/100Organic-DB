/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Insumo;

/**
 *
 * @author 631410038
 */
@Stateless
public class InsumoFacade extends AbstractFacade<Insumo> {

    @PersistenceContext(unitName = "OrganicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsumoFacade() {
        super(Insumo.class);
    }
    
}
