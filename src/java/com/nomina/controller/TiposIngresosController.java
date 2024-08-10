package com.nomina.controller;

import com.nomina.entity.TiposIngresos;
import com.nomina.facade.TiposIngresosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tiposIngresosController")
@ViewScoped
public class TiposIngresosController extends AbstractController<TiposIngresos> {

    public TiposIngresosController() {
        // Inform the Abstract parent controller of the concrete TiposIngresos Entity
        super(TiposIngresos.class);
    }

}
