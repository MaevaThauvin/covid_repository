package modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cas {
	private int id_cas;
	private String nom_complet;
	private String telephone;
	private String adresse;
	private String code_postale;
	private int etat;
	private ArrayList<TestPcr> testPcr;
	private Map<String, String> erreurs = new HashMap<String, String>();


	public Cas(String nom_complet, String telephone, String adresse, String code_postale) {
		super();
		this.nom_complet = nom_complet;
		this.telephone = telephone;
		this.adresse = adresse;
		this.code_postale = code_postale;
		testPcr = new ArrayList<TestPcr>();
	}

	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getId_cas() {
		return id_cas;
	}	

	public void setId_cas(int id_cas) {
		this.id_cas = id_cas;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean ValidationNomComplet() {
		// Vérification que le prénom et le nom sont séparés d'un espage
			// throw new Exception("prénom et le nom doivent être séparés par un espage");
		if (!(nom_complet.contains(" "))) {
			setErreur("nomComplet", "Le nom et le prénom doit être séparés par un espace");
		}
		return nom_complet.contains(" ");
	}

	public boolean ValidationCodePostale() {
		// vérification longueur 4 //Vérification que le code postal est un entier
		if (code_postale.length() == 4 && code_postale.matches("[0-9]+")) {
			return true;
		}
		else {
			setErreur("code_postale", "Le code postal n'est pas valide");
			System.out.println("Le code postal n'est pas valide");
		}
		return false;
	}

	public boolean ValidationAdresse() {
		// Vérification que l'adresse est de longueur 8 au moins
		
		if(!(adresse.length() >= 8)) {
			setErreur("adresse", "l'adresse doit fait au moins 8 caractères");
		}
		return adresse.length() >= 8;
	}

	public boolean ValidationEtat() {
		// vérification que l'état est bien un entier
		if (etat % 1 == 0) {
			return true;
		}
		else {
			setErreur("etat", "l'état n'est pas un entier");
			System.out.println("l'état n'est pas un entier");
		}
		return false;
	}

	public boolean ValidationTelephone() {
		// ne contient pas d'espaces
		if (!telephone.contains(" ")) {
			// contient + ou 00
			if (telephone.contains("00") || telephone.contains("+")) {
				String tel="";
				if (telephone.contains("00")) {
					tel = telephone.substring(2);
				}
				if (telephone.contains("+")) {
					tel = telephone.substring(1);
				}
				// est de longueur min 8
				if (tel.length() == 8) {
					return true;
				}
			}
		}
		setErreur("telephone", "Telephone non valide, doit contenir 8 caractère et ne doit pas contenir d'espace");
		System.out.println("Telephone non valide");
		return false;
	}
	
	public void doTest() {
		// Génération du résultat du test
		int resultat;
		Random rd = new Random();
		boolean res = rd.nextBoolean();
		if (res) {
			resultat=1;
		}
		else
			resultat = -1;
		
		// Récupération de la date du test
		Calendar calendar = Calendar.getInstance();
		int jour = calendar.get(Calendar.DAY_OF_MONTH);
		int annee = calendar.get(Calendar.YEAR);
		int mois = calendar.get(Calendar.MONTH);
		mois++;
		System.out.println("La date du test est : ");
		System.out.println("jour : "+ jour);
		System.out.println("mois : "+ mois);
		System.out.println("annee : "+annee);
		
		//Création du test Pcr
		TestPcr tp = new TestPcr(jour, mois, annee, resultat);
		
		//Ajout du test Pcr à la liste des Tests du cas
		testPcr.add(tp);
		System.out.println("Le test a été ajouté à la liste de test");
		
	}
	
	public String testPcrHistorique() {
		String s="";
		for (int i=0; i<testPcr.size();i++) {
			s+="Test n°"+i+" : Date : "+testPcr.get(i).getJour()+"/"+testPcr.get(i).getMois()+"/"
					+ ""+testPcr.get(i).getAnnee()+"\n"+"Résultat : "+testPcr.get(i).getResultat()+"\n";			
		}
		return s;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

}
