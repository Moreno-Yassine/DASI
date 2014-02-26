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
public class PredictionAmour extends Prediction{
    
    private String partenaire;

    protected PredictionAmour() {
    }

    public PredictionAmour(int force, String contenu,String partenaire) {
        super(force, contenu);
        this.partenaire = partenaire;
    }
    
}
