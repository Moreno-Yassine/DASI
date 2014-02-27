/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Client;
import metier.modele.Employe;

/**
 *
 * @author Slifer
 */
public class EmployeDao {
    
    public static void createEmploye(Employe e)
    {
      EntityManager em = JpaUtil.obtenirEntityManager();
      em.persist(e);
    }

    public static List<Employe> findAllEmployes()
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT e FROM Employe e");
        List<Employe> listsearch = q.getResultList() ;
        return listsearch;
    }
   // public static List<Client> findRelatedClients(Employe e)
    //{
        
    //}
    public static Employe findEmployeById (int id)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Employe.class,id);
    }
}
