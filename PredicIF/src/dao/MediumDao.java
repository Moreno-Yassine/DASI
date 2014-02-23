/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Medium;

/**
 *
 * @author Slifer
 */
public class MediumDao {

    
    public static void createMedium(Medium m) 
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(m);
    }
    public static void deleteMedium (Medium m)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        em.remove(m);
    }


    public static List<Medium> findMediumClient(int numclient) 
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT m FROM Medium m");
        List<Medium> listsearch = q.getResultList() ;
        return listsearch;    
    }

    public static List<Medium> findallMedium() 
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT m FROM Medium");
        List<Medium> listsearch = q.getResultList() ;
        return listsearch;
    }
    
}
