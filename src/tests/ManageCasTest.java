package tests;

import java.sql.SQLException;

import dao.ManageCas;
import exception.NonExistentCasException;
import modele.Cas;

public class ManageCasTest {

	public static void main(String[] args) throws SQLException, NonExistentCasException {
		// TODO Auto-generated method stub
		//AJOUTER UN CAS DANS LA BDD
		Cas cas = new Cas("Maeva thau", "0012151613", "18 rue de marechal joffre", "3135");
//		ManageCas.ajouterCas(cas);
//		ManageCas.ajouterTestPcr(cas);
		
	}

}
