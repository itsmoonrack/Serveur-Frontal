/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.alma.interfaces;

/**
 *
 * @author judu
 */
public interface IProduit { 


   /**
    * Renvoie la catégorie d'un produit.
    * Une catégorie regroupe tous les Produits de même type.
    * <em>exemple :</em> couteau, livre, tondeuse, pull…
    *
    *
    * @return
    */
   public ICategorie getCategorie();

   /**
    * La description est facultative. Peut renvoyer <em>null</em> ou une chaîne vide.
    * @return
    */
   public String getDescription();

   /**
    * Renvoie l'id de persistance. C'est une clé primaire.
    * @return
    */
   public Long getId();

   /**
    * Renvoie la marque du produit.
    * @return
    */
   public String getMarque();


   /**
    * Renvoie le modèle du produit.
    * Le couple &lt;marque,produit&gt; est une clé primaire du produit.
    * @return
    */
   public String getModele();

   /**
    * Renvoie le prix du produit.
    * @return
    */
   public Double getPrice();

   /**
    * Renvoie l'état des stocks du produit.
    * @return
    */
   public Long getQuantity();

   public void setCategorie(ICategorie categorie);

   public void setDescription(String description);

   public void setId(Long id);

   public void setMarque(String marque);

   public void setModele(String modele);

   public void setPrice(Double price);

   public void setQuantity(Long quantity);

}
