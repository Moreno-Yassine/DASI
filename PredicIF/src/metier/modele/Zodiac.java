/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Slifer
 */

@Entity
public class Zodiac implements Serializable {
    
    private int mois;
    private String element;
    private String moislettre;
    
    @Id
    private String nom;

    public Zodiac(String nom,int mois,String moislettre,String element) {
        this.mois = mois;
        this.element = element;
        this.moislettre = moislettre;
        this.nom = nom;
    }


    
    protected Zodiac(){}

    public String getNom() {
        return nom;
    }
}
