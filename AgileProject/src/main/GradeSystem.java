package main;
import java.util.ArrayList;

public class GradeSystem {
	private ArrayList<Grades> grades;
	private ArrayList<Double> weights;
	
	public GradeSystem(){
		grades = new ArrayList<Grades>();
	}
	
	public boolean containsID(String ID){
		throw new UnsupportedOperationException();
	}
	
	public String showGrade(String ID){
		throw new UnsupportedOperationException();
	}
	
	public String showRank(String ID){
		throw new UnsupportedOperationException();
	}
	
	public boolean updateWeight(ArrayList<Double> weight){
		throw new UnsupportedOperationException();
	}
	
	public Double getWeight(int index) {
		throw new UnsupportedOperationException();
	}
}
