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
	String ID;
	String name;
	int lab1;
	int lab2;
	int lab3;
	int midTerm;
	int finalExam;
	int totalGrade;
	
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
		throw new UnsupportedOperationException();
	}
}
