package main;
import java.util.ArrayList;
import java.util.LinkedList;

/*************************************************************************
	/* class GradeSystem 
	/*	�i�� GradeSystem �������ާ@
	/*
	/*	Data Member:
	/*		grades: LinkedList, �x�s a list of student grades.
	/*	Constructor:
	/*		GradeSystems()
	/*	Public Method:
	/*		containsID(id): boolean, ��aList�O�_�t��id
	/*		showGrade(id): boolean, ��ܦ�id������, �Yid���s�b�h�^��false
	/*		showRank(id): boolean, ��ܦ�id���ƦW, �Yid���s�b�h�^��false
	/*		updateWeights(): ��s���ưt��
 	/* 		getWeight(index): �d���index��weight
/*************************************************************************/
public class GradeSystem {
	private LinkedList<Grades> grades;
	private LinkedList<Double> weights;
	
	/** ----------------------------------------------------------------------
	/*public GradeSystems () //�غc�l

	/*1. �}�� input file ��gradeInput.txt��
	/*2. ��Java LinkedList�غcan empty list of grades�s aList
	/*3. read line
	/*4. while not endOfFile
	/*1.	call Grades() �غcaGrade
	/*2.	�� Java Scanner �� scan line ��U���s�JaGrade
	/*3. 	aGrade.calculateTotalGrade(weights) �^��aTotalGrade�⥦�s�JaGrade
	/*4. 	�� aGrade �s�J aList
	/*   end while
	/**----------------------------------------------------------------------*/
	public GradeSystem(){
		grades = new LinkedList<Grades>();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean containsID(String id)
	/*		�� id �O�_�t�b aGradeSystem��
	/*		�s�b�h�^�� true�A���s�b�h�^�� false
	/**----------------------------------------------------------------------*/
	public boolean containsID(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean showGrade(String id)
	/*		�Yid���s�b�h�^��false
	/*		��ܦ� id ���U������
	/**----------------------------------------------------------------------*/
	public String showGrade(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean showRank(String id)
	/*	1. ���o�o ID �� theTotalGrade
	/*	2. �Orank �� 1 
	/*	3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank�[1(�h1�W) end loop
	/*	4. show �o ID �� rank
	/**----------------------------------------------------------------------*/
	public String showRank(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public void updateWeights()
	/*		showOldWeights():	��ܭ쥻���t��
	/*		getNewWeights():	���ϥΪ̿�J�s�t��
	/*		�T�{��J��weights�M�O�_��1
	/*		if(true)
	/* 			�T�{��J
	/*			setWeights(weights):�T�{���sweights
	/*			Loop: ���s�p��Ҧ�id��TotalGrade
	/*		else ��ܿ�J���~ 
	/**----------------------------------------------------------------------*/
	public boolean updateWeight(ArrayList<Double> weight){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public Double getWeight(int index)
	/*		�ھ�index�d��s�bweights�̤��P���Z��weight
	/**----------------------------------------------------------------------*/
	public Double getWeight(int index) {
		throw new UnsupportedOperationException();
	}
}
