package modeles;

import java.util.Observable;

public class Test extends Observable{

	public Test(){
		
	}
	
	public Double[][] getData(){
		Double[][] vector = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
		return vector;
	}
}
