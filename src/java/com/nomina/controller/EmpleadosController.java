package com.nomina.controller;

import com.nomina.entity.Empleados;
import com.nomina.entity.RegistroTransacciones;
import java.util.Collection;
import com.nomina.facade.EmpleadosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController extends AbstractController<Empleados> {

    // Flags to indicate if child collections are empty
    private boolean isRegistroTransaccionesCollectionEmpty;

    public EmpleadosController() {
        // Inform the Abstract parent controller of the concrete Empleados Entity
        super(Empleados.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroTransaccionesCollectionEmpty();
    }

    public boolean getIsRegistroTransaccionesCollectionEmpty() {
        return this.isRegistroTransaccionesCollectionEmpty;
    }

    private void setIsRegistroTransaccionesCollectionEmpty() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            this.isRegistroTransaccionesCollectionEmpty = ejbFacade.isRegistroTransaccionesCollectionEmpty(selected);
        } else {
            this.isRegistroTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistroTransacciones
     * entities that are retrieved from Empleados and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistroTransacciones page
     */
    public String navigateRegistroTransaccionesCollection() {
        Empleados selected = this.getSelected();
        if (selected != null) {
            EmpleadosFacade ejbFacade = (EmpleadosFacade) this.getFacade();
            Collection<RegistroTransacciones> selectedRegistroTransaccionesCollection = ejbFacade.findRegistroTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistroTransacciones_items", selectedRegistroTransaccionesCollection);
        }
        return "/app/registroTransacciones/index";
    }

}
