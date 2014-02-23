/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Slifer
 */
@Entity
public class Medium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nummedium;
    private String nom;
    @ManyToMany
    private List<Client> clients;



    public Medium() {
    }

    public Medium(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
     
    
    
}
