
package metier.service;

import dao.ClientDao;
import dao.JpaUtil;
import dao.MediumDao;
import dao.PredictionDao;
import dao.ZodiacDao;
import java.util.ArrayList;
import java.util.List;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.Prediction;
import metier.modele.Zodiac;

/**
 *
 * @author Administrateur
 */
public class ServiceVoyance {
    
    // Methodes de créations d'entités
    public static void creerClient(Client c)
    {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDao.createClient(c);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
    }
    public static void creerZodiac(Zodiac z)
    {
       JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ZodiacDao.createZodiac(z);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager(); 
    }
    public static void creerMedium(Medium m)
    {
       JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        MediumDao.createMedium(m);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager(); 
    }
    public static void creerPrediction (Prediction p)
    {
       JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDao.createPrediction(p);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager(); 
    }
    
    // Methodes de get de list persist
    public static List<Client> listeClient()
    {
        JpaUtil.creerEntityManager();
        List<Client> result = ClientDao.findallClients();
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static List<Client> listeClientNom(String nom)
    {
        JpaUtil.creerEntityManager();
        List<Client> result = ClientDao.findbyNom(nom);
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Zodiac> listeZodiac()
    {
        JpaUtil.creerEntityManager();
        List<Zodiac> result = ZodiacDao.findallZodiac();
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Medium> listeMedium()
    {
        JpaUtil.creerEntityManager();
        List<Medium> result = MediumDao.findallMedium();
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Medium> listeMediumClient(int numclient)
    {
        JpaUtil.creerEntityManager();
        List<Medium> result = MediumDao.findMediumClient(numclient);
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static List<Prediction> listePrediction ()
    {
        JpaUtil.creerEntityManager();
        List<Prediction> result = PredictionDao.findallPredictions();
        JpaUtil.fermerEntityManager();
        return result;  
    }
    public static List<Prediction> listePredictionforce (int force)
    {
        JpaUtil.creerEntityManager();
        List<Prediction> result = PredictionDao.findPredictionforce(force);
        JpaUtil.fermerEntityManager();
        return result;  
    }
    public static List<Prediction> listePredictionAmour ()
    {
        JpaUtil.creerEntityManager();
        List<Prediction> result = PredictionDao.findPredictionAmour();
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static List<Prediction> listePredictionTravail ()
    {
        JpaUtil.creerEntityManager();
        List<Prediction> result = PredictionDao.findPredictionTravail();
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static List<Prediction> listePredictionSante ()
    {
        JpaUtil.creerEntityManager();
        List<Prediction> result = PredictionDao.findPredictionSante();
        JpaUtil.fermerEntityManager();
        return result;
    }
    
        //Services  annexes
        
        public static Zodiac compatible (int mois)
        {
        JpaUtil.creerEntityManager();
        Zodiac result = ZodiacDao.findCompatible(mois);
        JpaUtil.fermerEntityManager();
        return result;  
        }
        public static List<Medium> creationListe(){
            
        int nbMedium =(int) (Math.random()*3 +2 );   
        List<Medium> mediumGeneral = listeMedium();
        List<Medium> mediumClient = new ArrayList<Medium>();
        int[] nbTombes = new int[5];
        boolean correct = false;
        for (int i=0; i < nbMedium; i++){
            int medium = 0;
            int indice = 0;
           // while(correct == false){
             
            int buffer =(int) (Math.random()* mediumGeneral.size());
            //correct = testRedondance( nbTombes,buffer );
            medium=buffer;
            
            //}
            nbTombes[indice] = medium;
            indice ++;
            mediumClient.add(mediumGeneral.get(medium)); 
            
            }
        
        return mediumClient;
       
        }
        static boolean testRedondance (int[] Ref, int Teste){
            for(int i=0; i<5; i++){
                if(Teste == Ref[i]){
                return false;
                }
            }
            return true;
        }  
}
