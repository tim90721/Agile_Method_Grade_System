package main;
import java.util.*;

/*************************************************************************
/* class Grades
/*	�x�s User ���������: ID, Name, Grades
/*
/*	Data Member:
/*	 	id:	String, User ID
/*	 	name: String, User name
/*		lab1: int, Grade
/*	 	lab2: int, Grade
/*	 	lab3: int, Grade
/*		midTerm: int, Grade
/*	 	finalExam: int, Grade
/*	 	totalGrade: int, �W�����������ƨ� weight �[�v�p��
/*	Constructor:
/*		Grades()
/*	Public Method:
/*		calculateTotalGrade(List<Double> weights): ��weights�p��totalGrade�A�å|�ˤ��J
/*************************************************************************/
public class Grades {
	private String ID;
	private String name;
	private int lab1;
	private int lab2;
	private int lab3;
	private int midTerm;
	private int finalExam;
	private int totalGrade;
	
	/** ----------------------------------------------------------------------
	/*	public Grades
	/*		do nothing
	/**----------------------------------------------------------------------*/
	public Grades(){
		
	}
	
	/** ----------------------------------------------------------------------
	/*	public void calculateTotalGrade(List<Double> weights)
	/* 		��weights�p��totalGrade�A�å|�ˤ��J
	/**----------------------------------------------------------------------*/
	public int calculateTotalGrade(List<Double> weights){
		totalGrade = Math.round( weights.get(0).floatValue() * this.lab1 +
				weights.get(1).floatValue() * this.lab2 +
				weights.get(2).floatValue() * this.lab3 +
				weights.get(3).floatValue() * this.midTerm +
				weights.get(4).floatValue() * this.finalExam);
		return totalGrade;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLab1() {
		return lab1;
	}
	
	public int getLab2() {
		return lab2;
	}
	
	public int getLab3() {
		return lab3;
	}
	
	public int getMidTerm() {
		return midTerm;
	}
	
	public int getFinal() {
		return finalExam;
	}
	
	public void setGrade(String ID, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
	}
}
