package metier.modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numclient;
    private String civilite;
    private String nom;
    private String prenom;
    private int journaissance;
    private int moisnaissance;
    private int anneenaissance;
    private String adresse;
    private String telephone;
    private String email;
    @ManyToOne
    private Zodiac signe;
    @ManyToMany(mappedBy = "clients")
    private List<Medium> mediumsfav;
    

    protected Client() {
    }

    public Client(String civilite, String nom, String prenom, int journaissance, int moisnaissance, int anneenaissance, String adresse, String telephone, String email, Zodiac signe, List<Medium> mediumsfav) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.journaissance = journaissance;
        this.moisnaissance = moisnaissance;
        this.anneenaissance = anneenaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.signe = signe;
        this.mediumsfav = mediumsfav;
    }

    public String caracteristiques(){
        
        String buff;
        buff= this.civilite +" "+ this.nom +" "+ this.prenom +" "+ this.journaissance+
              " "+ this.moisnaissance+" "+ this.anneenaissance +" "+ this.adresse +" "+ this.telephone
                +" "+ this.email+" "+ this.signe.getNom();
        return buff;
    }
       
}
