package metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import metier.modele.Employe;
import metier.modele.Medium;
import metier.modele.Zodiac;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-27T01:49:35")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, Integer> numclient;
    public static volatile SingularAttribute<Client, String> civilite;
    public static volatile ListAttribute<Client, Medium> mediumsfav;
    public static volatile SingularAttribute<Client, Employe> superviseur;
    public static volatile SingularAttribute<Client, String> telephone;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, Zodiac> signe;

}