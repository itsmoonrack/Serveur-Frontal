/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.alma.interfaces;

import java.util.List;
import javax.ejb.Remote;

/**
 * Définit l'interface pour accéder à un catalogue.
 * On doit pouvoir accéder aux produits par différents critères.
 *
 * @author judu
 */
@Remote
public interface CatalogueRemote {


   /**
    * Récupère un produit persisté par son id dans la table.
    * @param id Identifiant de persistance.
    * @return le produit s'il existe, <em>null</em> sinon.
    */
   public IProduit findProduit(Long id);


   /**
    * Renvoie tous les items du catalogue.
    * @return
    */
   public List<IProduit> findAllProduits();


   /**
    * Renvoie une catégorie identifiée par son id de presistance.
    * @param id
    * @return
    */
   public ICategorie findCategorie(Long id);


   /**
    * Renvoie la liste des catégories.
    * @return
    */
   public List<ICategorie> findAllCategories();


   /**
    * Renvoie une catégorie identifiée par son nom.
    * @param name
    * @return
    */
   public ICategorie findCategorieByName(String name);

   /**
    * Permet de retrouver un produit par sa marque et son modèle.
    * Le couple &lt;marque,modèle&gt; doit constituer une clé primaire de la table.
    *
    * @param marque
    * @param modele
    * @return
    */
   public IProduit findByMarqueAndModele(String marque, String modele);

   /**
    * Permet de récupérer les produits d'une marque.
    * @param marque
    * @return
    */
   public List<IProduit> findByMarque(String marque);

   /**
    * Permet de récupérer tous les produits classés dans la même catégorie.
    * La catégorie doit être présente en base.
    * @param categorie la catégorie des produits voulus.
    * @return
    */
   public List<IProduit> findByCategorie(String categorieName);


   /**
    *
    * @param categorie
    * @return
    */
   public List<IProduit> findByCategorie(ICategorie categorie);


   /**
    * Permet de filtrer tous les produits d'une catégorie en fonction de leur prix.
    * Si <em>lowPrice</em> est strictement supérieur à <em>highPrice</em>, la liste retournée doit être vide.
    *
    * @param categorie La catégorie des produits voulus.
    * @param lowPrice La borne inférieure de l'intervalle de prix.
    * @param highPrice La borne supérieure de l'intervalle de prix.
    * @return
    */
   public List<IProduit> findByCategorieAndPriceRange(String categorie, Double lowPrice, Double highPrice);



    
}
