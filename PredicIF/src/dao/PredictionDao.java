/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import metier.modele.Prediction;

/**
 *
 * @author Slifer
 */
public class PredictionDao {
    
 
    public static void createPrediction (Prediction p)
    {
        EntityManager em = JpaUtil.obtenirEntityManager(); 
        em.persist(p);
    }
    
    public static void deletePrediction (Prediction p)
    {
        EntityManager em = JpaUtil.obtenirEntityManager(); 
        em.remove(p);  
    }
    
    public static List<Prediction> findallPredictions ()
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT p FROM Prediction p");
        return q.getResultList();
    }
    
    public static List<Prediction> findPredictionforce (int forcefiltre)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT p FROM Prediction p WHERE p.force ="+forcefiltre);
        return q.getResultList();
    }
    
    public static Prediction getPrediction(int numpredic)
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        return em.find(Prediction.class,numpredic);
    }
    public static List<Prediction> findPredictionAmour ()
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT p FROM PredictionAmour p");
        return q.getResultList();  
    }
    public static List<Prediction> findPredictionTravail()
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT p FROM PredictionTravail p");
        return q.getResultList();  
    }
    public static List<Prediction> findPredictionSante()
    {

        EntityManager em = JpaUtil.obtenirEntityManager();
        Query q = em.createQuery("SELECT p FROM PredictionSante p");
        return q.getResultList();  
    }
}
