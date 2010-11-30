/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.alma.interfaces;

/**
 *
 * @author judu
 */
public interface ICategorie {

   /**
    * Id de persistance. C'est une clé primaire.
    * @return
    */
   Long getId();

   /**
    * Nom de la catégorie. doit être unique dans la table.
    * @return
    */
   String getName();

   void setId(Long id);

   void setName(String name);

}
