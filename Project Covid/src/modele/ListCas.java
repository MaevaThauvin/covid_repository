package modele;

import java.util.ArrayList;

public class ListCas {
	private static ArrayList<Cas> listCas;
	
	public ListCas() {
		listCas = new ArrayList<Cas>();
		// TODO Auto-generated constructor stub
	}

	public void AjouterCas(Cas cas) {
		if (cas.ValidationAdresse() && cas.ValidationCodePostale() && cas.ValidationEtat() && cas.ValidationNomComplet()
				&& cas.ValidationTelephone()) {
			// Ajoute un cas à la liste
			listCas.add(cas);
			System.out.println("Le cas a bien été ajouté");
		}
		else {
			System.out.println("adresse : "+cas.ValidationAdresse());
			System.out.println("code postale : "+cas.ValidationCodePostale());
			System.out.println("etat : "+cas.ValidationEtat());
			System.out.println("Nom complet : "+cas.ValidationNomComplet());
			System.out.println("Telephone : "+cas.ValidationTelephone());
			System.out.println("Le cas n'a pas été ajouté car ses données ne sont pas valides");	
		}	
	}

	public String AfficherCas() {
		String s = "";
		if (listCas.size()!= 0) {
			// Afficher les cas de la liste
			for (int i = 0; i < listCas.size(); i++) {
				s += "Cas n° : " + listCas.get(i).getId_cas() + "\n";
				s += "Nom complet :: " + listCas.get(i).getNom_complet() + "\n";
				s += "Telephone : " + listCas.get(i).getTelephone() + "\n";
				s += "Adresse : " + listCas.get(i).getAdresse() + "\n";
				s += "Code postal : " + listCas.get(i).getCode_postale() + "\n";
				s += "Etat : " + listCas.get(i).getEtat() + "\n";
			}
			return s;
		}
		return "";
	}
	

	public boolean VerifierExistenceCas(int id) {
		// retourne si oui ou non le cas est présent dans la liste
		for (int i = 0; i < listCas.size(); i++) {
			if (id == listCas.get(i).getId_cas()) {
				return true;
			}
		}
		return false;
	}
}
