/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.EntreprisePartenaire;

/**
 *
 * @author Slifer
 */
public class EntreprisePartenaireDao {
    
    public static void createEP(EntreprisePartenaire ep)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
      em.persist(ep);
    }
    
    public static List<EntreprisePartenaire> findAllEP()
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT ep FROM EntreprisePartenaire ep");
        List<EntreprisePartenaire> listsearch = q.getResultList() ;
        return listsearch;
    }
}
