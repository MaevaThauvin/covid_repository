package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modele.ListCas;
import modele.TestPcr;
import utile.Date;

public class DateTest {
	
	Date date;
	TestPcr tp ;
	ListCas listCas;
	
	@Before
	public void init() {
		date = new Date();
		tp = new TestPcr(18, 01, 2020, -1);
		listCas = new ListCas();		
	}
	
	@Test
	public void testIdteste() {
		//assertEquals(false, listCas.VerifierExistenceCas(tp.getId_teste()));
	}

    @Test
    public void testDayIsInvalid() {
    	assertEquals(false, date.isValide(32, 02, 2012));
    }

    @Test
    public void testMonthIsInvalid() {
    	assertEquals(false, date.isValide(31, 20, 2012));
    }

    @Test
    public void testYearIsInvalid() {
    	assertEquals(false, date.isValide(31, 20, 19991));
    }

    @Test
    public void testDateFeb29__2012() {
    	assertEquals(true, date.isValide(29, 02, 2012));
    }

    @Test
    public void testDateFeb29__2011() {
    	assertEquals(false, date.isValide(29, 02, 2011));
    }

    @Test
    public void testDateFeb28() {
    	assertEquals(true, date.isValide(28, 02, 2011));
    }

    @Test
    public void testDateIsValid__1() {
    	assertEquals(true, date.isValide(31, 01, 2012));
    }

    @Test
    public void testDateIsValid__2() {
    	assertEquals(true, date.isValide(30, 04, 2012));
    }

    @Test
    public void testDateIsValid__3() {
    	assertEquals(true, date.isValide(31, 05, 2012));
    }
}
