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
public class PredictionSante extends Prediction{

    private String Conseil;

    protected PredictionSante() {
    }

    public PredictionSante(int force, String contenu, String Conseil) {
        super(force, contenu);
        this.Conseil = "conseil :"+ Conseil;
    }

    
    
}
