package com.nomina.entity;

import com.nomina.entity.RegistroTransacciones;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-08-10T02:49:05")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile CollectionAttribute<Empleados, RegistroTransacciones> registroTransaccionesCollection;
    public static volatile SingularAttribute<Empleados, String> cedula;
    public static volatile SingularAttribute<Empleados, BigDecimal> salarioMensual;
    public static volatile SingularAttribute<Empleados, Integer> id;
    public static volatile SingularAttribute<Empleados, String> nombre;

}