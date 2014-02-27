/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Slifer
 */
@Entity
public class Employe implements Serializable {
    @OneToMany(mappedBy = "superviseur")
    private List<Client> clients;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numEmploye;
    private String civilite;
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datedenaissance;
    private String adresse;
    private String tel;
    private String mail;

    protected Employe() {
    }

    public Employe(String civilite, String nom, String prenom, Date datedenaissance, String adresse, String tel, String mail) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.mail = mail;
        this.clients = new ArrayList<Client>();
    }

    public int getNumEmploye() {
        return numEmploye;
    }

    
       
}
