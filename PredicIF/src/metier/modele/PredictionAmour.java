/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

/**
 *
 * @author Slifer
 */
public class PredictionAmour extends Prediction{
    
    private Zodiac partenaire;

    public PredictionAmour(Zodiac partenaire, int force, String contenu) {
        super(force, contenu);
        this.partenaire = partenaire;
    }

    public Zodiac getPartenaire() {
        return partenaire;
    }
    
    
    
}
