package vue;

import java.io.IOException;
import util.LectureDonneesCsv;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.service.ServiceVoyance;

/**
 *
 * @author Administrateur
 */
public class PredicIF {
    
    public static void main(String[] args) {
         LectureDonneesCsv M;
        try {
            M = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Mediums.csv");
            
            M.lireMedium(10);
            M.fermer();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
       LectureDonneesCsv Z;
        try {
            Z = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-SignesAstrologiques.csv");         
            Z.lireZodiac(100);           
            Z.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        LectureDonneesCsv E;
        try {
            E = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Employes.csv");         
            E.lireEmploye(100);           
            E.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        LectureDonneesCsv L;
        try {
            L = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Clients.csv");         
            L.lireClients(10);           
            L.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
          LectureDonneesCsv PA;
        try {
            PA = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Predictions-Amour.csv");         
            PA.lirePredictionAmour(100);           
            PA.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        LectureDonneesCsv PS;
        try {
            PS = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Predictions-Sante.csv");         
            PS.lirePredictionSante(100);           
            PS.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        LectureDonneesCsv PT;
        try {
            PT = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Predictions-Travail.csv");         
            PT.lirePredictionTravail(100);           
            PT.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        String buff = ServiceVoyance.horoscope(55,76, 200, 279);
        System.out.println(buff);
    }
}
