package metier.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

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
    private String adresse;
    private String telephone;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @ManyToOne
    private Zodiac signe;
    @ManyToMany(mappedBy = "clients")
    private List<Medium> mediumsfav;
    @ManyToOne
    private Employe superviseur;
    

    protected Client() {
    }

    public Client(String civilite, String nom, String prenom, Date date, String adresse, String telephone, String email, Zodiac signe, List<Medium> mediumsfav,Employe emp) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = date;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.signe = signe;
        this.mediumsfav = mediumsfav;
        this.superviseur=emp;
    }

}
