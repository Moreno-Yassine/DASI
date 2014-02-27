package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Client;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-27T01:49:35")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, String> prenom;
    public static volatile SingularAttribute<Employe, String> mail;
    public static volatile SingularAttribute<Employe, Date> datedenaissance;
    public static volatile SingularAttribute<Employe, Integer> numEmploye;
    public static volatile SingularAttribute<Employe, String> adresse;
    public static volatile SingularAttribute<Employe, String> tel;
    public static volatile SingularAttribute<Employe, String> civilite;
    public static volatile SingularAttribute<Employe, String> nom;
    public static volatile ListAttribute<Employe, Client> clients;

}