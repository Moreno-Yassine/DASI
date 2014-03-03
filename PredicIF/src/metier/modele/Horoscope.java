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
public class Horoscope {
    
    private Client c;
    private PredictionAmour pa;
    private PredictionSante ps;
    private PredictionTravail pt;

    public Horoscope(Client c, PredictionAmour pa, PredictionSante ps, PredictionTravail pt) {
        this.c = c;
        this.pa = pa;
        this.ps = ps;
        this.pt = pt;
    }
    
    
    
}
