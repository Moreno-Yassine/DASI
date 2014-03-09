package vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.LectureDonneesCsv;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.Prediction;
import metier.service.ServiceVoyance;
import util.Saisie;

/**
 *
 * @author Administrateur
 */
public class PredicIF {
    
    public static void affichageClient(Client c)
    {
           System.out.println("Client "+c.getNumclient()+ " : "+ c.getCivilite()+ " " +c.getNom() + " " +c.getPrenom() + ", habitant à " +c.getAdresse()+ ", téléphone: " 
                   +c.getTelephone() + ", e-mail: " + c.getEmail()+ ", Signe :" +c.getSigne().getNom());
           System.out.print("Mediums Favoris : ");
           List<Medium> listMedium= c.getMediumsfav();
           for (int j=0;j<listMedium.size();j++)
           {
               System.out.print(listMedium.get(j).getNom()+ " ");
           }
           System.out.println();
    }

    public static void affichagePrediction(Prediction p)
    {
           System.out.println(p.getNumPrediction()+ "  ["+p.getForce()+"]  "+p.getContenu());
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
        boolean exit = false;
        
        while (!exit)
        {
            int choix = 0;
            String choisirInvite = "Selectionnez l'action voulue :" +"\r\n" + "1 : Listes Clients  2 : Inscription Client  3 : Création Horoscope  4: Quitter" +"\r\n";
            List<Integer> permissive = new ArrayList();
            permissive.add(1);
            permissive.add(2);
            permissive.add(3);
            permissive.add(4);
            choix = Saisie.lireInteger(choisirInvite, permissive); // Lecture de la saisie

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
                            affichageClient(listAffichage.get(i));
                        }
                    }
                    if (choix == 2)
                    {
                        choisirInvite = " Nom a chercher : ";
                        String recherche = Saisie.lireChaine(choisirInvite);
                        List<Client> listRecherche = ServiceVoyance.listeClientNom(recherche);
                        for (int i=0; i<listRecherche.size();i++)
                        {
                            affichageClient(listRecherche.get(i));
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

                case 3 :
                    int numClient;
                    int numPa;
                    int numPs;
                    int numPt;
                    List<Client> listAffichage = ServiceVoyance.listeClient();
                        for (int i=0; i<listAffichage.size();i++)
                        {
                            affichageClient(listAffichage.get(i));
                        }
                    choisirInvite = "Selectionnez Votre Client : " ; 
                    numClient= Saisie.lireInteger(choisirInvite);
                    List<Prediction> listPA = ServiceVoyance.listePredictionAmour();
                    // Afficher List
                        for (int i=0; i<listPA.size();i++)
                        {
                            affichagePrediction(listPA.get(i));
                        }
                    // getNuméro PA
                    choisirInvite = "Selectionnez Votre Prediction Amour";
                     numPa= Saisie.lireInteger(choisirInvite);
                    List<Prediction> listPT = ServiceVoyance.listePredictionTravail();
                    //Afficher List
                        for (int i=0; i<listPA.size();i++)
                        {
                            affichagePrediction(listPT.get(i));
                        }
                    // getNuméroPT
                    choisirInvite = "Selectionnez Votre Prediction Travail";
                     numPt= Saisie.lireInteger(choisirInvite);
                    List<Prediction> listPS = ServiceVoyance.listePredictionSante();
                    //Afficher List
                        for (int i=0; i<listPA.size();i++)
                        {
                            affichagePrediction(listPS.get(i));
                        }
                    //getNuméro PS
                    choisirInvite = "Selectionnez Votre Prediction Sante";
                     numPs= Saisie.lireInteger(choisirInvite);
                    
                    
                    System.out.println("Apercu de l'Horoscope");
                    System.out.println(ServiceVoyance.horoscope(numClient, numPa, numPs, numPt));
                    System.out.println("Apercu de l'Email");
                    System.out.println(ServiceVoyance.email(numClient, numPa, numPs, numPt));
                    
                    int envoi = Saisie.lireInteger(" 1:Envoyer 2:Annuler ");
                    if (envoi == 1)
                    {
                       System.out.println("Horoscope envoyé"); 
                    }
                    else
                    {
                       System.out.println("Envoi annulé"); 
                    }
                    break;
                    
                case 4 :
                    exit = true;
                    break;
            }
        

         }
    }
}
