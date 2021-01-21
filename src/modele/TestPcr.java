package modele;

public class TestPcr {
	private int jour;
	private int mois;
	private int annee;
	private int id_testPcr;
	private int resultat;
		
	public TestPcr(int jour, int mois, int annee, int resultat) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.resultat = resultat;
	}
	
	public int getResultat() {
		return resultat;
	}
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
	public int getJour() {
		return jour;
	}
	public int getMois() {
		return mois;
	}
	public int getAnnee() {
		return annee;
	}
	public int getId_testPcr() {
		return id_testPcr;
	}

	public void setJour(int jour) {
		this.jour = jour;
	} 

	public void setMois(int mois) {
		this.mois = mois;
	}

	public void setAnnée(int année) {
		this.annee = année;
	}

	public void setId_testPcr(int id_testePcr) {
		this.id_testPcr = id_testePcr;
	}
	
	
	
}
