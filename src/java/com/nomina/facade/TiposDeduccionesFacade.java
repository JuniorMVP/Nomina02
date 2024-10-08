/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nomina.facade;

import com.nomina.entity.TiposDeducciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author junior
 */
@Stateless
public class TiposDeduccionesFacade extends AbstractFacade<TiposDeducciones> {

    @PersistenceContext(unitName = "nomina02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposDeduccionesFacade() {
        super(TiposDeducciones.class);
    }
    
}
