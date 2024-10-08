/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nomina.facade;

import com.nomina.entity.RegistroTransacciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.nomina.entity.RegistroTransacciones_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.nomina.entity.Empleados;

/**
 *
 * @author junior
 */
@Stateless
public class RegistroTransaccionesFacade extends AbstractFacade<RegistroTransacciones> {

    @PersistenceContext(unitName = "nomina02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroTransaccionesFacade() {
        super(RegistroTransacciones.class);
    }

    public boolean isIdEmpleadoEmpty(RegistroTransacciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroTransacciones> registroTransacciones = cq.from(RegistroTransacciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroTransacciones, entity), cb.isNotNull(registroTransacciones.get(RegistroTransacciones_.idEmpleado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleados findIdEmpleado(RegistroTransacciones entity) {
        return this.getMergedEntity(entity).getIdEmpleado();
    }
    
}
