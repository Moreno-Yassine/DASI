package vue;

import java.util.ArrayList;
import java.util.List;
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
        ServiceVoyance.creerZodiac(Pois);
        ServiceVoyance.creerZodiac(Capri);
        
        Medium irma =new Medium("Irma");
        ServiceVoyance.creerMedium(irma);
        
        List<Medium> listmedium= new ArrayList<Medium>();
        listmedium.add(irma);
        
        Client bob = new Client("Mr", "bob", "bob",12,2,1992,"25 RUE Bob",
                "0606060606", "bob.bob@gmail.com",ServiceVoyance.compatible(2),listmedium);
        
        Client alice = new Client("Mlle", "alice", "alice",15,1,1668,"2 RUE ob",
                "0606606457", "alice.alice@gmail.com",ServiceVoyance.compatible(1),listmedium);
        
        Client claire = new Client("Mlle", "alice", "claire",15,2,1888,"2 RUE ob",
                "0606606457", "alice.alice@gmail.com",ServiceVoyance.compatible(2),listmedium);

        
        ServiceVoyance.creerClient(bob);
        ServiceVoyance.creerClient(alice);
        ServiceVoyance.creerClient(claire);

        
        
        afficherlist(ServiceVoyance.ListeClient());
        afficherlist(ServiceVoyance.ListeClientNom("alice"));
        afficherlistzodiac(ServiceVoyance.ListeZodiac());
    }
}
