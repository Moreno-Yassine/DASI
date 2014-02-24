package metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Client;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-24T17:46:55")
@StaticMetamodel(Medium.class)
public class Medium_ { 

    public static volatile SingularAttribute<Medium, Integer> nummedium;
    public static volatile SingularAttribute<Medium, String> biographie;
    public static volatile SingularAttribute<Medium, String> talent;
    public static volatile SingularAttribute<Medium, String> civilite;
    public static volatile SingularAttribute<Medium, String> nom;
    public static volatile ListAttribute<Medium, Client> clients;

}