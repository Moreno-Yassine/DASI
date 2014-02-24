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
public class PredictionSante extends Prediction{

    private String Conseil;

    public PredictionSante(String Conseil, int force, String contenu) {
        super(force, contenu);
        this.Conseil = "conseil :"+ Conseil;
    }

    
    
}
