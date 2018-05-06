package main;
import java.util.ArrayList;
import java.util.LinkedList;

/*************************************************************************
	/* class GradeSystem 
	/*	進行 GradeSystem 的相關操作
	/*
	/*	Data Member:
	/*		grades: LinkedList, 儲存 a list of student grades.
	/*	Constructor:
	/*		GradeSystems()
	/*	Public Method:
	/*		containsID(id): boolean, 看aList是否含此id
	/*		showGrade(id): boolean, 顯示此id的分數, 若id不存在則回傳false
	/*		showRank(id): boolean, 顯示此id的排名, 若id不存在則回傳false
	/*		updateWeights(): 更新分數配分
 	/* 		getWeight(index): 查找第index個weight
/*************************************************************************/
public class GradeSystem {
	private LinkedList<Grades> grades;
	private LinkedList<Double> weights;
	
	/** ----------------------------------------------------------------------
	/*public GradeSystems () //建構子

	/*1. 開檔 input file “gradeInput.txt”
	/*2. 用Java LinkedList建構an empty list of grades叫 aList
	/*3. read line
	/*4. while not endOfFile
	/*1.	call Grades() 建構aGrade
	/*2.	用 Java Scanner 來 scan line 把各欄位存入aGrade
	/*3. 	aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade
	/*4. 	把 aGrade 存入 aList
	/*   end while
	/**----------------------------------------------------------------------*/
	public GradeSystem(){
		grades = new LinkedList<Grades>();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean containsID(String id)
	/*		看 id 是否含在 aGradeSystem內
	/*		存在則回傳 true，不存在則回傳 false
	/**----------------------------------------------------------------------*/
	public boolean containsID(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean showGrade(String id)
	/*		若id不存在則回傳false
	/*		顯示此 id 的各項分數
	/**----------------------------------------------------------------------*/
	public String showGrade(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public boolean showRank(String id)
	/*	1. 取得這 ID 的 theTotalGrade
	/*	2. 令rank 為 1 
	/*	3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank加1(退1名) end loop
	/*	4. show 這 ID 的 rank
	/**----------------------------------------------------------------------*/
	public String showRank(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public void updateWeights()
	/*		showOldWeights():	顯示原本的配分
	/*		getNewWeights():	讓使用者輸入新配分
	/*		確認輸入的weights和是否為1
	/*		if(true)
	/* 			確認輸入
	/*			setWeights(weights):確認後更新weights
	/*			Loop: 重新計算所有id的TotalGrade
	/*		else 顯示輸入錯誤 
	/**----------------------------------------------------------------------*/
	public boolean updateWeight(ArrayList<Double> weight){
		throw new UnsupportedOperationException();
	}
	
	/** ----------------------------------------------------------------------
	/*	public Double getWeight(int index)
	/*		根據index查找存在weights裡不同成績的weight
	/**----------------------------------------------------------------------*/
	public Double getWeight(int index) {
		throw new UnsupportedOperationException();
	}
}
