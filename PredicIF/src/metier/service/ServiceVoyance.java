
package metier.service;

import dao.ClientDao;
import dao.JpaUtil;
import dao.MediumDao;
import dao.ZodiacDao;
import java.util.List;
import javax.persistence.EntityManager;
import metier.modele.Client;
import metier.modele.Medium;
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
    
    // Methodes de get de list persist
    public static List<Client> ListeClient()
    {
        JpaUtil.creerEntityManager();
        List<Client> result = ClientDao.findallClients();
        JpaUtil.fermerEntityManager();
        return result;
    }
    public static List<Client> ListeClientNom(String nom)
    {
        JpaUtil.creerEntityManager();
        List<Client> result = ClientDao.findbyNom(nom);
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Zodiac> ListeZodiac()
    {
        JpaUtil.creerEntityManager();
        List<Zodiac> result = ZodiacDao.findallZodiac();
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Medium> ListeMedium()
    {
        JpaUtil.creerEntityManager();
        List<Medium> result = MediumDao.findallMedium();
        JpaUtil.fermerEntityManager();
        return result;
    }
        public static List<Medium> ListeMediumClient(int numclient)
    {
        JpaUtil.creerEntityManager();
        List<Medium> result = MediumDao.findMediumClient(numclient);
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
}
