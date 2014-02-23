/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Zodiac;

/**
 *
 * @author Slifer
 */
public class ZodiacDao {
    
   
    
    public static void createZodiac(Zodiac z)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(z);
    }
    public static void updateZodiac (Zodiac c)
    {
       EntityManager em = JpaUtil.obtenirEntityManager();
       em.merge(c); 
    }
    public static void deleteZodiac (Zodiac c)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        em.remove(c);
    }
    public static List<Zodiac> findbyNom (String search)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("Select z from Zodiac z where z.nom=\"" +search+"\"");      
        List<Zodiac> listsearch = q.getResultList() ;
        return listsearch;
                
    }

    public static List<Zodiac> findallZodiac ()
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT z FROM Zodiac z");
        List<Zodiac> listsearch = q.getResultList() ;
        return listsearch;
    }
    
    public static Zodiac findCompatible(int x)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("Select z FROM Zodiac z WHERE z.mois ="+ x);
        Zodiac result; 
            result = (Zodiac) q.getSingleResult();
        return result;
    }
}
