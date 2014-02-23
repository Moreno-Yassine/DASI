/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Client;

/**
 *
 * @author Administrateur
 */
public class ClientDao {
    
    
    public static void createClient (Client c)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        em.persist(c);
    }
    public static void updateClient (Client c)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
       em.merge(c); 
    }
    public static void deleteClient (Client c)
    { EntityManager em = JpaUtil.obtenirEntityManager();
        em.remove(c);
    }
    public static List<Client> findbyNom (String search)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT c FROM Client c WHERE c.nom = \"" +search + "\"");      
        List<Client> listsearch = q.getResultList() ;
        return listsearch;
                
    }
    public static Client findbyId (int id)
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Client.class,id);
    }
    
    public static List<Client> findallClients ()
    {
         EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT c FROM Client c");
        List<Client> listsearch = q.getResultList() ;
        return listsearch;
    }
}
