/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Slifer
 */
@Entity
public class EntreprisePartenaire {
    @Id
    String nom;
    String Email;

    protected EntreprisePartenaire() {
    }

    public EntreprisePartenaire(String nom, String Email) {
        this.nom = nom;
        this.Email = Email;
    }
    
}
