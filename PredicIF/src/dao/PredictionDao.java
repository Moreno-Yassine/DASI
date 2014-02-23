/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.persistence.EntityManager;
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
    
}
