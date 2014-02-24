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
    protected int numPrediction;
    protected int force;
    protected String contenu;

    public Prediction(int force, String contenu) {
        this.force = force;
        this.contenu = contenu;
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
    
}
