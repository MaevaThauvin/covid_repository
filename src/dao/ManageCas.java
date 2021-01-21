package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import exception.NonExistentCasException;
import modele.Cas;
import modele.ListCas;
import modele.TestPcr;
import utile.Date;

public class ManageCas implements Serializable {
	public static Connection conn = Connecteur.getConnection();
	public static ArrayList<Cas> listCas = getListCas();
	public static ArrayList<TestPcr> listTest = getListTest();

	public ManageCas() {
		
	}

	public static void ajouterCas(Cas cas) throws SQLException, NonExistentCasException {
		// Ajout du cas
		if (cas.ValidationAdresse() && cas.ValidationCodePostale() && cas.ValidationEtat()
				&& cas.ValidationNomComplet() && cas.ValidationTelephone()) {
			java.sql.PreparedStatement prstAddCas;
			prstAddCas = conn.prepareStatement(
					"insert into cas(id_cas, nom_complet, telephone, adresse, code_postale, etat) value(?,?,?,?,?,?)");
			prstAddCas.setInt(1, cas.getId_cas());
			prstAddCas.setString(2, cas.getNom_complet());
			prstAddCas.setString(3, cas.getTelephone());
			prstAddCas.setString(4, cas.getAdresse());
			prstAddCas.setString(5, cas.getCode_postale());
			prstAddCas.setInt(6, cas.getEtat());
			prstAddCas.execute();
		}			
		else
			System.out.println("Le cas n'est pas valide et n'a pas été ajouté à la Bdd covid");		
	}

	public static ArrayList<Cas> getListCas() {
		java.sql.Statement st;
		ResultSet rs;
		ArrayList<Cas> liste = new ArrayList<Cas>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select id_cas, nom_complet, telephone, adresse, code_postale, etat from cas ");
			if (rs != null) {
				while (rs.next()) {
					
					String id_cas = rs.getString("id_cas");
					String nom_complet = rs.getString("nom_complet");
					String telephone = rs.getString("telephone");
					String adresse = rs.getString("adresse");
					String code_postale = rs.getString("code_postale");
					int etat = rs.getInt("etat");

					Cas cas = new Cas(nom_complet, telephone, adresse, code_postale);
					cas.setId_cas(Integer.parseInt(id_cas));
					cas.setEtat(etat);
					
					if (cas.ValidationAdresse() && cas.ValidationCodePostale() && cas.ValidationEtat() && cas.ValidationNomComplet()
							&& cas.ValidationTelephone()) {
						// Ajoute un cas à la liste
						liste.add(cas);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public static void ajouterTestPcr(Cas cas, TestPcr testpcr) throws SQLException, NonExistentCasException {
		// Vérification de l'existance du cas dans le bdd
		java.sql.PreparedStatement prst;
		prst = conn.prepareStatement("select * from cas where id_cas=?");
		prst.setInt(1, cas.getId_cas());
		ResultSet rs = prst.executeQuery();
		if (rs.next()) {
			// Ajout du test
						java.sql.PreparedStatement prstAddTest;
						prstAddTest = conn.prepareStatement(
								"insert into testPcr(jour, mois, annee, resultat, id_teste) value(?,?,?,?,?)");
//						Calendar calendar = Calendar.getInstance();
//						int jour = calendar.get(Calendar.DAY_OF_MONTH);
//						int annee = calendar.get(Calendar.YEAR);
//						int mois = calendar.get(Calendar.MONTH);
//						mois++;
//						
//						int resultat;
//						Random rd = new Random();
//						boolean res = rd.nextBoolean();
//						if (res) {
//							resultat=1;
//						}
//						else
//							resultat = -1;				
						
						int jour = testpcr.getJour();
						int mois = testpcr.getMois();
						int annee = testpcr.getAnnee();
						int resultat = testpcr.getResultat();

						cas.setEtat(resultat);;
						
						prstAddTest.setInt(1, jour);
						prstAddTest.setInt(2, mois);
						prstAddTest.setInt(3, annee);
						prstAddTest.setInt(4, resultat);
						prstAddTest.setInt(5, cas.getId_cas());
						prstAddTest.execute();
						
						//Mise a jour de l'etat du cas
						java.sql.PreparedStatement prst2;
						prst2 = conn.prepareStatement("update cas set  etat =? where id_cas =?");
						prst2.setInt(1, cas.getEtat());
						prst2.setInt(2, cas.getId_cas());
						prst2.execute();	
		} else {
			throw new NonExistentCasException("L'utilisateur n'existe pas");
		}	
	}
	
	public static Cas getCasByID(int id_cas) {
		java.sql.PreparedStatement prst;
		try {
			prst = conn.prepareStatement("select * from cas where id_cas=?");
			prst.setInt(1, id_cas);
			ResultSet rs = prst.executeQuery();
			String nom_complet="";
			String telephone="";
			String adresse="";
			String code_postale="";
			while (rs.next()) {
				nom_complet = rs.getString("nom_complet");
				telephone = rs.getString("telephone");
				adresse = rs.getString("adresse");
				code_postale = rs.getString("code_postale");
			}
			Cas cas = new Cas(nom_complet, telephone, adresse, code_postale);
			cas.setId_cas(id_cas);
			return cas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	public static ArrayList<TestPcr> getListTest() {
		// TODO Auto-generated method stub
		java.sql.Statement st;
		ResultSet rs;
		ArrayList<TestPcr> liste = new ArrayList<TestPcr>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select id_testPcr, jour, mois, annee, resultat, id_teste from testpcr ");
			if (rs != null) {
				while (rs.next()) {
					
					int id_testPcr = rs.getInt("id_testPcr");
					int jour = rs.getInt("jour");
					int mois = rs.getInt("mois");
					int annee = rs.getInt("annee");
					int resultat = rs.getInt("resultat");
					int id_teste = rs.getInt("id_teste");
					Date date = new Date();
					if (date.isValide(jour, mois, annee)) {
						TestPcr testpcr = new TestPcr(jour, mois, annee, resultat);
						testpcr.setId_testPcr(id_testPcr);
						liste.add(testpcr);
					}	
					else {
						System.out.println("Le test n'a pas été passé car la date n'est pas valide");	
					}	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public static ArrayList<TestPcr> getListTestById(int id_cas) {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement prst;
		ArrayList<TestPcr> liste = new ArrayList<TestPcr>();
		try {
			prst = conn.prepareStatement("select id_testPcr, jour, mois, annee, resultat from testpcr tp join cas c on tp.id_teste = c.id_cas where c.id_cas=?");
			prst.setInt(1, id_cas);
			ResultSet rs = prst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					
					int id_testPcr = rs.getInt("id_testPcr");
					int jour = rs.getInt("jour");
					int mois = rs.getInt("mois");
					int annee = rs.getInt("annee");
					int resultat = rs.getInt("resultat");
					Date date = new Date();
					if (date.isValide(jour, mois, annee)) {
						TestPcr testpcr = new TestPcr(jour, mois, annee, resultat);
						testpcr.setId_testPcr(id_testPcr);
						liste.add(testpcr);
						System.out.println("Le test a bien été passé");
					}	
					else {
						System.out.println("Le test n'a pas été passé car la date n'est pas valide");	
					}	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
}
