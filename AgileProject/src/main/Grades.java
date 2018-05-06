package main;
import java.util.*;

/*************************************************************************
/* class Grades
/*	儲存 User 的相關資料: ID, Name, Grades
/*
/*	Data Member:
/*	 	id:	String, User ID
/*	 	name: String, User name
/*		lab1: int, Grade
/*	 	lab2: int, Grade
/*	 	lab3: int, Grade
/*		midTerm: int, Grade
/*	 	finalExam: int, Grade
/*	 	totalGrade: int, 上面五項的分數依 weight 加權計算
/*	Constructor:
/*		Grades()
/*	Public Method:
/*		calculateTotalGrade(List<Double> weights): 依weights計算totalGrade，並四捨五入
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
	/* 		依weights計算totalGrade，並四捨五入
	/**----------------------------------------------------------------------*/
	public int calculateTotalGrade(List<Double> weights){
		throw new UnsupportedOperationException();
	}
}
