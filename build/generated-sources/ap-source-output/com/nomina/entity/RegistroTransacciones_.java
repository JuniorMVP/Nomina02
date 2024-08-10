package com.nomina.entity;

import com.nomina.entity.Empleados;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-08-10T02:49:05")
@StaticMetamodel(RegistroTransacciones.class)
public class RegistroTransacciones_ { 

    public static volatile SingularAttribute<RegistroTransacciones, Integer> idAsiento;
    public static volatile SingularAttribute<RegistroTransacciones, Date> fecha;
    public static volatile SingularAttribute<RegistroTransacciones, Boolean> estado;
    public static volatile SingularAttribute<RegistroTransacciones, BigDecimal> monto;
    public static volatile SingularAttribute<RegistroTransacciones, Empleados> idEmpleado;
    public static volatile SingularAttribute<RegistroTransacciones, Integer> id;
    public static volatile SingularAttribute<RegistroTransacciones, Character> tipoTransaccion;
    public static volatile SingularAttribute<RegistroTransacciones, Integer> idIngresoDeduccion;

}