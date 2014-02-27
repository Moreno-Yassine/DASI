/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author Slifer
 */
@Entity
public class PredictionTravail extends Prediction{

    protected PredictionTravail() {
    }

    public PredictionTravail(int force, String contenu) {
        super(force, contenu);
    }
    
    
}
