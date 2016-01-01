package modeles;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Gestion d'un 'historique' de 'cotation's
 * @author Vincent
 *
 */
public class Historique {
	
	// attributs
	private List<Cotation> liste;
	private String ticker;
	
	// constructeurs
	public Historique() {
		this.ticker = null;
		this.liste = new ArrayList<>();
	}
	
	// Accesseurs
	public int taille() {
		return liste.size();
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public List<Cotation> getListe() {
		return liste;
	}
	
	
	public Cotation getCotation(int index){
		return liste.get(index);
	}
	
	// Méthodes publiques de gestion de la liste (à compléter éventuellement)
	public void ajouter(Cotation cot){
		if (this.ticker == null)
			this.ticker = cot.getTicker();
		liste.add(cot);
	}
	
	public Cotation supprimer(int index) {
		return liste.remove(index);
	}
	
	public Cotation supprimerPremiere() {
		return liste.remove(0);
	}
	
	public Cotation supprimerDate(String chaine) {
		GregorianCalendar cal = Cotation.parseDate(chaine);
		int index = 0;
		for (Cotation cot : this.liste) {
			if (cot.getDate().equals(cal))
				return liste.remove(index);
			index++;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "";
		for (Cotation cot : liste)
			res += cot.toString() + "\n";
		return res;		
	}
}