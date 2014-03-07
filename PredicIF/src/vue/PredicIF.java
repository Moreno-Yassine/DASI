package vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.LectureDonneesCsv;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.modele.Client;
import metier.modele.Medium;
import metier.service.ServiceVoyance;
import util.Saisie;

/**
 *
 * @author Administrateur
 */
public class PredicIF {
    
    public static void AffichageClient(Client c)
    {
           System.out.println("Client: "+ c.getCivilite()+ " " +c.getNom() + " " +c.getPrenom() + ", habitant à " +c.getAdresse()+ ", téléphone: " 
                   +c.getTelephone() + ", e-mail: " + c.getEmail()+ ", Signe :" +c.getSigne().getNom());
           System.out.print("Mediums Favoris : ");
           List<Medium> listMedium= c.getMediumsfav();
           for (int j=0;j<listMedium.size();j++)
           {
               System.out.print(listMedium.get(j).getNom()+ " ");
           }
           System.out.println();
    }
    
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
        
        int choix = 0;
        String choisirInvite = "Selectionnez l'action voulue :" +"\r\n" + "1 : Listes Clients  2 : Inscription Client  3 : Création Horoscope" +"\r\n";
        List<Integer> permissive = new ArrayList();
        permissive.add(1);
        permissive.add(2);
        permissive.add(3);
        choix = Saisie.lireInteger(choisirInvite, permissive);
        
        switch (choix)
        {
            case 1 :
                choisirInvite = "1 : Liste Complete, 2 : Recherche Par Nom";
                choix = Saisie.lireInteger(choisirInvite, permissive);
                if (choix == 1)
                {
                    List<Client> listAffichage = ServiceVoyance.listeClient();
                    for (int i=0; i<listAffichage.size();i++)
                    {
                        AffichageClient(listAffichage.get(i));
                    }
                }
                if (choix == 2)
                {
                    choisirInvite = " Nom a chercher : ";
                    String recherche = Saisie.lireChaine(choisirInvite);
                    List<Client> listRecherche = ServiceVoyance.listeClientNom(recherche);
                    for (int i=0; i<listRecherche.size();i++)
                    {
                        AffichageClient(listRecherche.get(i));
                    }
                }
                break;
                
            case 2 :
                String[] description = new String[7];
                description[0] = Saisie.lireChaine("Veuillez saisir la Civilité du client : ");
                description[1] = Saisie.lireChaine("Veuillez saisir le Nom du client : ");
                description[2] = Saisie.lireChaine("Veuillez saisir le Prénom du client : ");
                description[3] = Saisie.lireChaine("Veuillez saisir la Date de Naissance du client (Format AAAA-MM-JJ) : ");
                description[4] = Saisie.lireChaine("Veuillez saisir l'Adresse du client : ");
                description[5] = Saisie.lireChaine("Veuillez saisir le Téléphone du client : ");
                description[6] = Saisie.lireChaine("Veuillez saisir l'E-mail du client : ");
                
                try {
                 L = new LectureDonneesCsv("C:\\Users\\Slifer\\Documents\\Projects\\DASI\\PredicIF\\src\\Données\\PredictIF-Clients.csv");         
                 L.creerClient(description);
                } catch (IOException ex) {
                    Logger.getLogger(PredicIF.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
        

    }
}
