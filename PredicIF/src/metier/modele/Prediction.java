/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Slifer
 */

@Entity
public class Prediction implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numPrediction;
    private int force;
    private String contenu;
    private String type;

    public Prediction(int force, String contenu, String type) {
        this.force = force;
        this.contenu = contenu;
        this.type = type;
    }

    protected Prediction() {
    }

    public int getNumPrediction() {
        return numPrediction;
    }

    public int getForce() {
        return force;
    }

    public String getContenu() {
        return contenu;
    }

    public String getType() {
        return type;
    }
    
    
    
}
