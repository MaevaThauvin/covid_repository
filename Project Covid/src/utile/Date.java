package utile;

public class Date {
	
	private int[] moisJours31 = {1, 3, 5, 7, 8, 10, 12};
	private int[] moisJours30 = {4, 6, 9, 11};
	
	public boolean isValide(int jour, int mois, int annee) {
		if (mois<=12 && mois >=1 && jour > 1 && jour <= 31) {			
			if( mois==02 && annee%4==0 && jour <=29) {
				return true;
			}
			if (mois == 02 && !(annee%4==0) && jour <=28) {
				return true;
			}
			
			for( int i=0; i<moisJours31.length;i++) {
				if (mois==moisJours31[i] && jour<=31) {
					return true;
				}
			}
			
			for( int i=0; i<moisJours30.length;i++) {
				if (mois==moisJours30[i] && jour<=30) {
					return true;
				}
			}			
		}
		return false;
	}
	
}
