/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import java.util.List;
import util.Aleatoire;

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
    
    public String getFormat()
    {
        String buffer;
        buffer = c.getCivilite() + c.getNom()+" "+ c.getPrenom() + "\r\n";
        buffer += c.getEmail() +"\r\n";
        buffer += c.getTelephone() +"\r\n";
        buffer += "Mediums Favoris : ";
        List<Medium> buffMed = c.getMediumsfav();
        for (int i=0; i<buffMed.size();i++)
        {
            buffer+= buffMed.get(i).getNom()+" ";
        }
        buffer += "\r\n" +"\r\n";
        buffer += "Amour : " + pa.getContenu()+"\r\n";
        buffer += "Signe Partenaire : "+pa.getPartenaire()+"\r\n"+"\r\n";
        buffer += "Travail : " + pt.getContenu()+"\r\n"+"\r\n";
        buffer += "Sante : "+ps.getContenu()+"\r\n";
        buffer += "Conseil : "+ ps.getConseil() +"\r\n"+"\r\n";
        
        buffer += "Cordialement"+"\r\n";
        int voyantDuJour = Aleatoire.random(0, buffMed.size());
        buffer +="Votre Medium du jour : "+ buffMed.get(voyantDuJour).getNom()+"\r\n";
        
        return buffer;
    }
    
    
}
