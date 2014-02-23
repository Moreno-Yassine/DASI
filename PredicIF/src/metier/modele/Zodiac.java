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
    
    @Id
    private String nom;

    public Zodiac(int mois, String nom) {
        this.mois = mois;
        this.nom = nom;
    }
    
    protected Zodiac(){}
    
    public String caracteristiques(){
        String buff;
        buff= this.nom +" "+ this.mois;
        return buff;
    }

    public String getNom() {
        return nom;
    }
}
