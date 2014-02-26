package util;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import metier.modele.Client;
import metier.modele.Medium;
import metier.modele.PredictionAmour;
import metier.modele.PredictionSante;
import metier.modele.PredictionTravail;
import metier.modele.Zodiac;
import metier.service.ServiceVoyance;

/**
 * La classe LectureDonneesCsv permet (comme son nom l'indique) la lecture de données CSV
 * dans des fichiers. Elle doit être complétée et personnalisée pour interagir avec VOTRE couche
 * service pour la création effective des entités. Elle comprend initialement la lecture d'un fichier
 * Clients et d'un fichier Pays. Une méthode {@link main()} permet de tester cette classe avant de
 * l'intégrer dans le reste de votre code.
 * @author Équipe DASI - 2013/2014
 */

public class LectureDonneesCsv {

    /**
     * Format de date pour la lecture des dates dans les fichiers CSV fournis.
     */
    protected static DateFormat CSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * Format de date pour l'affichage à l'écran.
     */
    protected static DateFormat USER_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Le lecteur de fichier CSV.
     * Il doit être initialisé avant l'appel aux méthodes de la classe.
     */
    protected CSVReader lecteurFichier;

    /**
     * Unique constructeur de la classe. Le fichier CSV donné en paramètre doit
     * avoir le point-virgule ';' comme séparateur et être encodé en UTF-8. Le fichier est
     * immédiatement ouvert (en lecture) par ce constructeur.
     * @param cheminVersFichier Chemin vers le fichier CSV.
     * @throws FileNotFoundException Si le chemin vers le fichier n'est pas valide ou le fichier non-lisible.
     */
    public LectureDonneesCsv(String cheminVersFichier) throws FileNotFoundException, UnsupportedEncodingException {

        this.lecteurFichier = new CSVReader(new InputStreamReader(new FileInputStream(cheminVersFichier), "UTF-8"), ';');
    }
    
    
    /**
     * Ferme le fichier CSV. Les autres méthodes ne doivent plus être appelées après cela.
     * @throws IOException 
     */
    public void fermer() throws IOException {

        this.lecteurFichier.close();
    }

    /**
     * Méthode statique pour lire une date à partir d'une chaîne de caractère.
     * Adapté au format de date des fichiers CSV fournis, par exemple: 2014-02-01.
     * @param date Chaîne de caractère représentant la date.
     * @return La date interpétée ou la date actuelle en cas mauvais format en entrée.
     */
    protected static Date parseDate(String date) {
        try {
            return CSV_DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }
    
    /**
     * Méthode statique pour formater une date pour l'affichage.
     * Par exemple: 01/02/2014.
     * @param date Date à formater.
     * @return Chaîne de caractère représentant la date.
     */
    protected static String formatDate(Date date) {
        return USER_DATE_FORMAT.format(date);
    }

    /**
     * Méthode statique pour afficher l'en-tête d'un fichier CSV lu par le lecteur.
     * L'affichage se fait sur la "sortie d'erreur" (en rouge dans la console sous Netbeans).
     * Le nom des colonnes est précédé de leur index dans le tableau (commençant à 0).
     * @param colonnes le tableau des noms de colonnes.
     */
    protected static void afficherEnTeteCsv(String[] colonnes) {
        
        for (int i=0; i<colonnes.length; i++) {
            if (i>0) {
                System.err.print("; " );
            }
            System.err.print("#" + Integer.toString(i) + " => " + colonnes[i] );
        }
        System.err.println();
    }
    
    /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Client pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lireClients(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {    
            creerClient(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lireMedium(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
  
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
            creerMedium(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionAmour(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
  
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
            creerPredictionAmour(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionTravail(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
  
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
            creerPredictionTravail(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lirePredictionSante(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
  
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
            creerPredictionSante(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    public void lireZodiac(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
  
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
            creerZodiac(nextLine);
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    /**
     * Créée un Medium à partir de sa description.
     * @param descriptionMedium Ligne du fichier CSV de Mediums.
     */
    public void creerMedium(String [] descriptionMedium){
        String civilite = descriptionMedium[0];
        String nom = descriptionMedium[1];
        String Talent = descriptionMedium[2];
        String Biographie = descriptionMedium[3];
        
        Medium medium = new Medium(descriptionMedium[0],descriptionMedium[1],descriptionMedium[2],descriptionMedium[3]);
        ServiceVoyance.creerMedium(medium);
    }
    /**
     * Créée une PredictionAmour à partir de sa description.
     * @param descriptionPredA Ligne du fichier CSV de PredictionsAmour.
     */
    public void creerPredictionAmour(String [] descriptionPredA){
        int force = Integer.parseInt(descriptionPredA[0]);
        String contenu = descriptionPredA[1];
        String part = descriptionPredA[2];
        
        PredictionAmour pa = new PredictionAmour(force,contenu,part);
        ServiceVoyance.creerPrediction(pa);
    }
    /**
     * Créée une PredictionTravail à partir de sa description.
     * @param descriptionPredT Ligne du fichier CSV de PredictionsTravail.
     */
    public void creerPredictionTravail(String [] descriptionPredT){
        int force = Integer.parseInt(descriptionPredT[0]);
        String contenu = descriptionPredT[1];
        
        PredictionTravail pt = new PredictionTravail(force,contenu);
        ServiceVoyance.creerPrediction(pt);
    }
    /**
     * Créée une PredictionSante à partir de sa description.
     * @param descriptionPredS Ligne du fichier CSV de PredictionsSante.
     */
    public void creerPredictionSante(String [] descriptionPredS){
        int force = Integer.parseInt(descriptionPredS[0]);
        String contenu = descriptionPredS[1];
        String conseil = descriptionPredS[2];
        
        PredictionSante ps = new PredictionSante(force,contenu,conseil);
        ServiceVoyance.creerPrediction(ps);
    }
    /**
     * Créée un Zodiac à partir de sa description.
     * @param descriptionZodiac Ligne du fichier CSV de Zodiac.
     */
    public void creerZodiac(String [] descriptionZodiac){
        String nom = descriptionZodiac[0];
        int mois = Integer.parseInt(descriptionZodiac[1]);
        String moisLettre = descriptionZodiac[2];
        String element = descriptionZodiac[3];
        
        Zodiac z = new Zodiac(nom,mois,moisLettre,element);
        ServiceVoyance.creerZodiac(z);
    }
    /**
     * Créée un Client à partir de sa description.
     * La date de naissance est notamment interpétée comme un objet Date.
     * @param descriptionClient Ligne du fichier CSV de Clients.
     */
    public void creerClient(String[] descriptionClient) {
        
        String civilite = descriptionClient[0];
        String nom = descriptionClient[1];
        String prenom = descriptionClient[2];
        Date dateNaissance = parseDate(descriptionClient[3]);
        String adresse = descriptionClient[4];
        String telephone = descriptionClient[5];
        String email = descriptionClient[6];
        
        System.out.println("Client: "+  civilite + " " + nom + " " + prenom + ", né le " + formatDate(dateNaissance) + ", habitant à " + adresse + ", téléphone: " + telephone + ", e-mail: " + email);
        //String civilite, String nom, String prenom, int journaissance, int moisnaissance, int anneenaissance, String adresse, String telephone, String email, Zodiac signe, List<Medium> mediumsfav
        Calendar C = Calendar.getInstance();
        C.setTime(dateNaissance);
        //System.out.println(C.get(C.MONTH));
       Client client = new Client(civilite, nom, prenom, dateNaissance, adresse, telephone, email,ServiceVoyance.compatible(C.get(C.MONTH)+1),ServiceVoyance.creationListe()) ;
        // À implémenter...
        //Client client = new Client(civilite,nom,prenom,dateNaissance,adresse,telephone,email);
        //System.out.println(client);
       ServiceVoyance.creerClient(client);
        
    }

    /**
     * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
     * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
     * @throws IOException 
     */
    public void lirePays(int limite) throws IOException {

        String[] nextLine;

         // En-tete du fichier CSV
        nextLine = this.lecteurFichier.readNext();
        afficherEnTeteCsv(nextLine);
        
        
        // Lecture des lignes
        while ((nextLine = this.lecteurFichier.readNext()) != null) {
        
            creerPays(nextLine);
            
            // Limite (ou -1 si pas de limite)
            if ( !(limite < 0) && (--limite < 1) ) {
                break;
            }
        }

    }
    
    /**
     * Créée un Pays à partir de sa description.
     * La superficie et la population sont notamment interpétées comme des nombres.
     * @param descriptionClient Ligne du fichier CSV de Pays.
     */
    public void creerPays(String[] descriptionPays) {
        
        String nom = descriptionPays[0];
        String code = descriptionPays[1];
        String region = descriptionPays[2];
        String capitale = descriptionPays[3];
        String langues = descriptionPays[4];
        Integer superficie = Integer.parseInt(descriptionPays[5]);
        Float population = Float.parseFloat(descriptionPays[6]);
        String regime = descriptionPays[7];
        
        System.out.println("Pays: "+  nom + " [" + code + "] (" + regime + "), Capitale: " + capitale + ", Région: " + region + ", Langues: " + langues + ", " + superficie + " km², " + population + " millions d'hbitants");
        
        // À implémenter...
        //Pays pays = new Pays(code,nom,capitale,population,superficie,langues);
        //System.out.println(pays);
        //Service.creerPays(pays);
        
    }
    
}
