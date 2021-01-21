package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modele.Cas;

public class CasTest {
	Cas cas, cas2, cas3;
	
	@Before
	public void init() {
		cas = new Cas("Jimmy Moriarty", "0058264549", "17", "312a");
		cas2 = new Cas("JimmyMoriarty", "0058264549", "17 rue du général Leclerc", "31200");
		cas3 = new Cas("Jimmy Moriarty", "0058264549", "17 rue du général Leclerc", "31200");
	}
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();

//	@Test
//	public void testValidationNomComplet() throws Exception {
//		//Vérification que le prénom et le nom sont séparés d'un espage		
//		//prenom et nom pas séparé par espace
//		exception.expect(Exception.class);
//		cas2.ValidationNomComplet();
//	}
	
	@Test
	public void testValidationNomComplet() throws Exception {
		//Vérification que le prénom et le nom sont séparés d'un espage		
		//prenom et nom pas séparé par espace
		assertEquals(false, cas2.ValidationNomComplet());
	}
	
	@Test
	public void testValidationCodePostale() {		
		//CP different de 4
		assertEquals(false, cas2.ValidationCodePostale());
		
		//Vérification que le code postal est un entier
		//CP n'est pas un entier
		assertEquals(false, cas.ValidationCodePostale());
		
		//CP longueur 5
		assertEquals(false, cas3.ValidationCodePostale());
		
	}
	
	@Test
	public void testValidationAdresse() {
		//Vérification que l'adresse est de longueur 8 au moins
		assertEquals(false, cas.ValidationAdresse());

	}
	
	@Test
	public void testValidationEtat() {
		//vérification que l'état est bien un entier
		assertTrue(cas.ValidationEtat());

	}
	
	@Test
	public void testValidationTelephone() {
		cas.setTelephone("00 12 15 16 14 18");
		//contient des espaces
		assertEquals(false, cas.ValidationTelephone());
		
		cas.setTelephone("15261345");
		//ne contient pas de + ou 00
		assertEquals(false, cas.ValidationTelephone());
		
		cas.setTelephone("001514181619");
		// est de longueur différent de 8
		assertEquals(false, cas.ValidationTelephone());

	}

	
	
	
	

}
