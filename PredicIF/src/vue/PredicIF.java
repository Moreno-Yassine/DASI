package vue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import util.LectureDonneesCsv;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.Zodiac;
import metier.service.ServiceVoyance;

/**
 *
 * @author Administrateur
 */
public class PredicIF {

    /**
     * @param listinput
     */
    public static void afficherlist(List<Client> listinput)
    {
        for (int k=0;k<listinput.size();k++)
        {
            System.out.println((listinput.get(k)).caracteristiques());
        }
    }

    /**
     *
     * @param listzod
     */
    public static void afficherlistzodiac(List<Zodiac> listzod)
    {
        for (int k=0;k<listzod.size();k++)
        {
            System.out.println((listzod.get(k)).caracteristiques());
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here      
              
        Zodiac Capri = new Zodiac(1,"Capricorne");
        Zodiac Pois = new Zodiac(2,"Poisson");
        Zodiac Sagi = new Zodiac (3, "Bob");
        Zodiac Alice = new Zodiac (4, "Alice");
        Zodiac Zeus = new Zodiac (5, "Zeus");
        Zodiac Hades = new Zodiac (6, "Hades");
        Zodiac Brob = new Zodiac (7, "Brob");
        Zodiac Zog = new Zodiac (8, "Zog");
        Zodiac A = new Zodiac (9, "A");
        Zodiac B = new Zodiac (10, "B");
        Zodiac C = new Zodiac (11, "C");
        Zodiac D = new Zodiac (12, "D");
        
        ServiceVoyance.creerZodiac(Pois);
        ServiceVoyance.creerZodiac(Capri);
        ServiceVoyance.creerZodiac(Sagi);
        ServiceVoyance.creerZodiac(Alice);
        ServiceVoyance.creerZodiac(Zeus);
        ServiceVoyance.creerZodiac(Hades);
        ServiceVoyance.creerZodiac(Brob);
        ServiceVoyance.creerZodiac(Zog);
        ServiceVoyance.creerZodiac(A);
        ServiceVoyance.creerZodiac(B);
        ServiceVoyance.creerZodiac(C);
        ServiceVoyance.creerZodiac(D);

         LectureDonneesCsv M;
        try {
            M = new LectureDonneesCsv("C:\\Documents and Settings\\Administrateur\\Mes documents\\NetBeansProjects\\DASI-master\\PredicIF\\src\\Données\\PredictIF-Mediums.csv");
            
            M.lireMedium(100);
            M.fermer();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        
        
        
        LectureDonneesCsv L;
        try {
            L = new LectureDonneesCsv("C:\\Documents and Settings\\Administrateur\\Mes documents\\NetBeansProjects\\DASI-master\\PredicIF\\src\\Données\\PredictIF-Clients.csv");         
            L.lireClients(100);           
            L.fermer();
            
        } catch (IOException ex) {
            Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
       
        }
    }
}
