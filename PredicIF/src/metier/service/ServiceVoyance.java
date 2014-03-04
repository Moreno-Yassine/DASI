
package metier.service;

import dao.ClientDao;
import dao.EmployeDao;
import dao.JpaUtil;
import dao.MediumDao;
import dao.PredictionDao;
import dao.ZodiacDao;
import java.util.ArrayList;
import java.util.List;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Horoscope;
import metier.modele.Medium;
import metier.modele.Prediction;
import metier.modele.PredictionAmour;
import metier.modele.PredictionSante;
import metier.modele.PredictionTravail;
import metier.modele.Zodiac;
import util.Aleatoire;

/**
 *
 * @author Administrateur
 */
public class ServiceVoyance {
    public static String horoscope(int numClient, int numPa, int numPs, int numPt)
    {
        Horoscope h = new Horoscope (idClient(numClient),idPredAmour(numPa),idPredSante(numPs),idPredTravail(numPt));
        return h.getFormat();
    }
    
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
    public static void creerEmploye (Employe e)
    {
       JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        EmployeDao.createEmploye(e);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager(); 
    }
    
    // Methodes de get de singles
    public static Client idClient(int id)
    {
        JpaUtil.creerEntityManager();
        Client result = ClientDao.findbyId(id);
        JpaUtil.fermerEntityManager();
        return result; 
    }
    public static PredictionAmour idPredAmour(int id)
    {
        JpaUtil.creerEntityManager();
        PredictionAmour result =(PredictionAmour)PredictionDao.getPrediction(id);
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static PredictionSante idPredSante(int id)
    {
        JpaUtil.creerEntityManager();
        PredictionSante result =(PredictionSante)PredictionDao.getPrediction(id);
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static PredictionTravail idPredTravail(int id)
    {
        JpaUtil.creerEntityManager();
        PredictionTravail result =(PredictionTravail)PredictionDao.getPrediction(id);
        JpaUtil.fermerEntityManager();
        return result;
    }
    
    // Methodes de get de list d'entités
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
    public static List<Employe> listeEmploye()
    {
        JpaUtil.creerEntityManager();
        List<Employe> result = EmployeDao.findAllEmployes();
        JpaUtil.fermerEntityManager();
        return result; 
    }
   /* public static List<Client> listeClientsPourEmploye (Employe e)
    {
        JpaUtil.creerEntityManager();
        List<Client> result = EmployeDao.findRelatedClients(e);
        JpaUtil.fermerEntityManager();
        return result;
    }*/
       
    
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
        for (int i=0; i < nbMedium; i++){
            int medium;
            int buffer =(int) (Math.random()* mediumGeneral.size());
            medium=buffer;
            mediumClient.add(mediumGeneral.get(medium)); 
            
            }
        return mediumClient;
        }
        
        public static Employe affectationEmploye()
        {
            List<Employe> all = listeEmploye();
            int rand = Aleatoire.random(0,all.size()-1);
            return all.get(rand);
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
