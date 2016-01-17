package modeles;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LinearRegression {

	double a;
	double b;
	double rSquare;
	
	public LinearRegression() {
		this.a = 0.0;
		this.b = 0.0;
		this.rSquare = 0.0;
	}

	public LinearRegression(double a, double b, double rSquare) {
		this.a = a;
		this.b = b;
		this.rSquare = rSquare;
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}
	
	/**
	 * @return the rSquare
	 */
	public double getRSquare() {
		return rSquare;
	}
	
	/**
	 * Calcul des paramètres de la droite de régression y = a*x + b et son coefficient r².
	 * Pour tracer la courbe, si x est la date et lr l'objet LinearRegression, alors la formule est :
	 * 		y = date.getTimeInMillis() * lr.getA() + lr.getB();
	 * @param x liste des abcisses (dates)
	 * @param y liste des ordonnées (open, close...)
	 * @return objet contenant les paramètres de la droite de régression
	 */
	public static LinearRegression calcLinearReg(List<GregorianCalendar> x, List<Double> y) {
		double a = 0.0, b = 0.0, rSquare;
		// transformer les dates en millisecondes
		List<Long> t = new ArrayList<>();
		for (int index = 0 ; index < x.size() ; index ++)
			t.add(x.get(index).getTimeInMillis());
		// Calcul des sommes
		int count = 0;
		double valT, valY, st = 0.0, sy = 0.0, sty = 0.0, stt = 0.0, syy = 0.0;
		while (count < t.size()) {
			valT = t.get(count);
			valY = y.get(count);
			st += valT;
			sy += valY;
			sty += valT * valY;
			stt += valT * valT;
			syy += valY * valY; // pour calcul du rSquare
			count++;
		}
		double varTvarY = (count * stt - st * st) * (count * syy - sy * sy); 
		a = (count * sty - st * sy) / (count * stt - st * st);
		b = (sy - a * st) / count;
		rSquare = Math.pow((count * sty - st * sy), 2) / varTvarY;
		return new LinearRegression(a, b, rSquare);
	}
	
	/*
	 * Première version où les écarts entre deux dates se comptent en jours et non en millisecondes
	 * Peut-être moins logique pour tracer la courbe (donne des valeurs similaires au calcul
	 * LibreOffice
	 */
//	public static LinearRegression calcLinearReg(List<GregorianCalendar> x, List<Double> y) {
//		double a = 0.0, b = 0.0, rSquare;
//		// transformer la liste de date en liste d'entier
//		List<Integer> t = new ArrayList<>();
//		for (int index = 0 ; index < x.size() ; index ++)
//			t.add(TestsDivers.nbJour(x.get(index), x.get(0)) * -1);
//		// Calcul des sommes
//		int count = 0;
//		double valT, valY, st = 0.0, sy = 0.0, sty = 0.0, stt = 0.0, syy = 0.0;
//		while (count < t.size()) {
//			valT = t.get(count);
//			valY = y.get(count);
//			st += valT;
//			sy += valY;
//			sty += valT * valY;
//			stt += valT * valT;
//			syy += valY * valY; // pour calcul du rSquare
//			count++;
//		}
//		double varTvarY = (count * stt - st * st) * (count * syy - sy * sy); 
//		a = (count * sty - st * sy) / (count * stt - st * st);
//		b = (sy - a * st) / count;
//		rSquare = Math.pow((count * sty - st * sy), 2) / varTvarY;
//		return new LinearRegression(a, b, rSquare);
//	}
}
