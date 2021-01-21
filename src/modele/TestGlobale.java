package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import modele.ListCas;

public class TestGlobale {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Login : ");
		String login = sc.next();
		System.out.println("Mot de passe : ");
		String pwd = sc.next();
		
		// Verification que l'utilisateur est bien administrateur
		Admin admin = new Admin(login, pwd);
		ListCas listCas = new ListCas();
		
		if (admin.ValidationLogin() && admin.ValidationLogin()) {
			//Demander le nombre de cas à ajouter
			System.out.println("Combien de cas souhaitez vous ajouter ? ");
			int nbCas = sc.nextInt();	
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			
			//Vérifier la validité du cas et l'ajouter
			for (int i=0; i<nbCas; i++) {
				System.out.println("Ajout du cas n° : "+i+1);
				System.out.println("Nom complet : ");
				String nomComplet = br.readLine();				
				System.out.println("Telephone : ");
				String telephone = br.readLine();
				System.out.println("Adresse : ");
				String adresse = br.readLine();
				System.out.println("Code Postal : ");
				String codePostale = br.readLine();
				System.out.println("Etat : ");
				int etat = sc.nextInt();
				Cas cas = new Cas(nomComplet, telephone, adresse, codePostale);
				cas.setEtat(etat);				
				//vérifier et ajouter le cas si valide
				listCas.AjouterCas(cas);				
			}	
			
			//Afficher tous les cas existants
			System.out.println(listCas.AfficherCas());	
		}
		else
			System.out.println("Vous n'êtes pas administrateur");
	}
}
