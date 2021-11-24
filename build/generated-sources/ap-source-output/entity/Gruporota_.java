package entity;

import entity.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-22T15:03:20")
@StaticMetamodel(Gruporota.class)
public class Gruporota_ { 

    public static volatile SingularAttribute<Gruporota, Integer> gdrid;
    public static volatile SingularAttribute<Gruporota, String> gdrdescricao;
    public static volatile CollectionAttribute<Gruporota, Cliente> clienteCollection;

}