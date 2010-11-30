package fr.alma.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.alma.server.Utilisateur;
import fr.alma.server.UtilisateurLocal;
import fr.alma.server.UtilisateurRemote;

public class Client {
	protected UtilisateurRemote utilisateur_service;
	
	public Client() throws NamingException {
		Context context = new InitialContext();
		utilisateur_service=(UtilisateurRemote) context.lookup("UtilisateurService/remote");
	}
	
	public void run() throws NoSuchAlgorithmException{
		menu();
	}
	
	private void menu() throws NoSuchAlgorithmException{
		while(true){
			System.out.println("Welcoooooooooooooooooooooome !!! What do you want to do ?");
			System.out.println("1- Gérer les utilisateurs");
			System.out.println("9- Quitter");
	
			Scanner sc = new Scanner(System.in);
			int choix_menu = sc.nextInt();
			
			switch(choix_menu){
			case 1:
				menuUtilisateur();
				break;
			case 2:
				showUtilisateur();
				break;
			case 3:
				removeUtilisateur();
				break;
			case 9:
				return;
			default :
				System.out.println("Problème dans le choix du menu");
			}
		}
	}
	
	private void menuUtilisateur() throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		System.out.println("Welcoooooooooooooooooooooome !!! What do you want to do ?");
		System.out.println("1- Ajouter un utilisateur");
		System.out.println("2- Voir vos utilisateurs");
		System.out.println("3- Supprimer un utilisateur");
		System.out.println("9- Retour");

		Scanner sc = new Scanner(System.in);
		int choix_menu = sc.nextInt();
		
		switch(choix_menu){
		case 1:
			addUtilisateur();
			menuUtilisateur();
			break;
		case 2:
			showUtilisateur();
			menuUtilisateur();
			break;
		case 3:
			removeUtilisateur();
			menuUtilisateur();
			break;
		case 9:
			return;
		default :
			System.out.println("Problème dans le choix du menu");
		}
	}

	private void removeUtilisateur() {
		System.out.println("Donner l'id de l'utilisateur a supprimé");
		Scanner sc = new Scanner(System.in);
		long id = sc.nextInt();
		int i = utilisateur_service.removeUtilisateur(id);
		if(i == 1){
			System.out.println("Utilisateur correctement supprimé");
		}
		else{
			System.out.println("Aucun utilisateur supprimé");
		}
	}

	private void showUtilisateur() {
		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) utilisateur_service.getUtilisateurs();
		for(Utilisateur u : utilisateurs){
			System.out.println(u);
		}
	}

	private void addUtilisateur() throws NoSuchAlgorithmException {
		String nom;
		String prenom;
		String pseudo;
		String motDePasse;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est votre nom");
		nom = sc.next();
		System.out.println("Quel est votre prénom");
		prenom = sc.next();
		System.out.println("Quel est votre pseudo");
		pseudo = sc.next();
		System.out.println("Quel est votre mot de passe");
		motDePasse = sc.next();
		addUtilisateur(nom, prenom, pseudo, motDePasse);
	}

	public void addUtilisateur(String nom, String prenom, String pseudo,
			String motDePasse) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		if(nom != null && !nom.isEmpty() &&
				prenom != null && !prenom.isEmpty() &&
				pseudo != null && !pseudo.isEmpty() &&
				motDePasse != null && !motDePasse.isEmpty()){
			long id = utilisateur_service.addUtilisateur(new Utilisateur(nom, prenom, pseudo, cryptage(motDePasse)));
			System.out.println("L'utilisateur "+id+" a bien été ajouté");
		}
	}

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NamingException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
		Client client = new Client();
		client.run();
	}
	
	private String cryptage(String value) throws NoSuchAlgorithmException{
		byte[] hash = null;
		hash = MessageDigest.getInstance("SHA-1").digest(value.getBytes());
		StringBuffer hashString = new StringBuffer(); 
		for ( int i = 0; i < hash.length; ++i ) { 
			String hex = Integer.toHexString(hash[i]); 
			if ( hex.length() == 1 ) { 
				hashString.append('0'); 
				hashString.append(hex.charAt(hex.length()-1)); 
			} else { 
				hashString.append(hex.substring(hex.length()-2)); 
			} 
		} 
	    return hashString.toString();
	}

}
