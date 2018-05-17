package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*************************************************************************
 * /* class GradeSystem /* 進行 GradeSystem 的相關操作 /* /* Data Member: /* grades:
 * LinkedList, 儲存 a list of student grades. /* Constructor: /* GradeSystems() /*
 * Public Method: /* containsID(id): boolean, 看aList是否含此id /* showGrade(id):
 * boolean, 顯示此id的分數, 若id不存在則回傳false /* showRank(id): boolean, 顯示此id的排名,
 * 若id不存在則回傳false /* updateWeights(): 更新分數配分 /* getWeight(index):
 * 查找第index個weight /
 *************************************************************************/
public class GradeSystem {
	private LinkedList<Grades> grades;
	private ArrayList<Double> weights;
	private static final String infile = "Input.txt";

	/**
	 * ----------------------------------------------------------------------
	 * /*public GradeSystems () //建構子
	 * 
	 * /*1. 開檔 input file “gradeInput.txt” /*2. 用Java LinkedList建構an empty list of
	 * grades叫 aList /*3. read line /*4. while not endOfFile /*1. call Grades()
	 * 建構aGrade /*2. 用 Java Scanner 來 scan line 把各欄位存入aGrade /*3.
	 * aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade /*4. 把 aGrade 存入
	 * aList /* end while
	 * /**----------------------------------------------------------------------
	 */
	public GradeSystem() {
		grades = new LinkedList<Grades>();
		weights = new ArrayList<Double>();

		weights.add(0.1);
		weights.add(0.1);
		weights.add(0.1);
		weights.add(0.3);
		weights.add(0.4);
		
		try {
			File file = new File(infile);
			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {
				System.out.println("a");
				String str = input.nextLine();
				if(str.equals(""))
					break;
				Grades aGrade = this.transferLineToGrades(str);

				this.grades.add(aGrade);
			}

			input.close();
		} catch (FileNotFoundException fe) {
			System.out.println("File " + infile + " not found!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public boolean containsID(String id) /* 看 id 是否含在 aGradeSystem內 /* 存在則回傳
	 * true，不存在則回傳 false
	 * /**----------------------------------------------------------------------
	 */
	public boolean containsID(String ID) {
		Grades aGrade = getGradeFromList(ID);
		if (aGrade == null)
			return false;
		return true;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public boolean showGrade(String id) /* 若id不存在則回傳false /* 顯示此 id 的各項分數
	 * /**----------------------------------------------------------------------
	 */
	public String showGrade(String ID) {
		Grades grade = getGradeFromList(ID);
		if (grade == null)
			return "Input Error";
		String message = grade.getName() + "成績:lab1:\t" + grade.getLab1() + "\n" + "lab2:\t" + grade.getLab2() + "\n"
				+ "lab3:\t" + grade.getLab3() + "\n" + "midTerm:\t" + grade.getMidTerm() + "\n" + "finalExam:\t"
				+ grade.getFinal() + "\n" + "total grade:\t" + grade.calculateTotalGrade(weights) + "\n";
		return message;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public boolean showRank(String id) /* 1. 取得這 ID 的 theTotalGrade /* 2. 令rank 為
	 * 1 /* 3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank加1(退1名)
	 * end loop /* 4. show 這 ID 的 rank
	 * /**----------------------------------------------------------------------
	 */
	public String showRank(String ID) {
		Grades theGrade = getGradeFromList(ID);
		String message = "";
		if (theGrade == null)
			return "Input Error";

		int rank = 1;
		for (Grades aGrade : grades) {
			if (aGrade.calculateTotalGrade(weights) > theGrade.calculateTotalGrade(weights))
				++rank;
		}
		message = theGrade.getName() + "排名第" + rank;
		return message;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public void updateWeights() /* showOldWeights(): 顯示原本的配分 /* getNewWeights():
	 * 讓使用者輸入新配分 /* 確認輸入的weights和是否為1 /* if(true) /* 確認輸入 /*
	 * setWeights(weights):確認後更新weights /* Loop: 重新計算所有id的TotalGrade /* else 顯示輸入錯誤
	 * /**----------------------------------------------------------------------
	 */
	public boolean updateWeight() {
		showOldWeight();
		double[] new_weights = getNewWeights();

		if (this.checkWeights(new_weights)) {
			System.out.println("請確認新配分");
			this.showWeight(new_weights);

			System.out.print("以上正確嗎? Y (Yes) 或 N (No)");
			Scanner input = new Scanner(System.in);
			String in = input.next();
			if (in.equals("Y")) {
				setWeights(new_weights);
				for (Grades aGrade : grades)
					aGrade.calculateTotalGrade(this.weights);
			}
		} else {
			System.out.println("配分輸入錯誤：比重相加不為1");
			return false;
		}
		return true;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public Double getWeight(int index) /* 根據index查找存在weights裡不同成績的weight
	 * /**----------------------------------------------------------------------
	 */
	public Double getWeight(int index) {
		return weights.get(index);
	}

	/*************************************************************************
	 * /* public String getGradeName(String id) /* 取得 id 所對應的名稱，若 id 不存在則回傳 null /
	 *************************************************************************/
	public String getGradeName(String ID) {
		System.out.println(ID);
		Grades grade = getGradeFromList(ID);
		return grade.getName();
	}

	/*************************************************************************
	 * /* private Grades transferLineToGrades(String line): /* 將讀到的資料行: 962001044
	 * 凌宗廷 87 86 98 88 87 進行切割 /* 存入aGrade之中，進行回傳。 /
	 *************************************************************************/
	private Grades transferLineToGrades(String line) {
		Grades aGrade = new Grades();
		System.out.println(line);
		String[] words = line.split(" +");

		String ID = words[0];
		System.out.println(ID);
		String name = words[1];
		
		int lab1 = Integer.parseInt(words[2]);
		int lab2 = Integer.parseInt(words[3]);
		int lab3 = Integer.parseInt(words[4]);
		int midTerm = Integer.parseInt(words[5]);
		int finalExam = Integer.parseInt(words[6]);
		aGrade.setGrade(ID, name, lab1, lab2, lab3, midTerm, finalExam);
		return aGrade;
	}

	/*************************************************************************
	 * /* private Grades getGradeFromList(String id): /* 自 aList 中依 id 找尋對應之 Grades
	 * 回傳, /* 若不存在則回傳 null /
	 *************************************************************************/
	private Grades getGradeFromList(String ID) {
		for (Grades grade : grades) {
			if (grade.getID().equals(ID))
				return grade;
		}
		return null;
	}

	/*************************************************************************
	 * /* private void showOldWeight(): 顯示原本的配分 /
	 *************************************************************************/
	private void showOldWeight() {
		System.out.println("舊配分");
		this.showWeight(this.weights);
	}

	/*************************************************************************
	 * /* private void showWeight(float[] weights): 依給定參數顯示配分 /
	 *************************************************************************/
	private void showWeight(List<Double> weights) {
		System.out.println("\tlab1\t" + Math.round(weights.get(0) * 100) + "%\n" + "\tlab2\t"
				+ Math.round(weights.get(1) * 100) + "%\n" + "\tlab3\t" + Math.round(weights.get(2) * 100) + "%\n"
				+ "\tmid-term\t" + Math.round(weights.get(3) * 100) + "%\n" + "\tfinal exam\t"
				+ Math.round(weights.get(4) * 100) + "%");
	}
	
	/*************************************************************************
	/*	private void showWeight(float[] weights): 依給定參數顯示配分
	/*************************************************************************/
	private void showWeight(double[] weights) {
		System.out.println( "\tlab1\t" + Math.round(weights[0]*100) + "%\n" +
							"\tlab2\t" + Math.round(weights[1]*100) + "%\n" +
							"\tlab3\t" + Math.round(weights[2]*100) + "%\n" +
							"\tmid-term\t" + Math.round(weights[3]*100) + "%\n" +
							"\tfinal exam\t" + Math.round(weights[4]*100) + "%");
	}
	

	/*************************************************************************
	 * /* private float[] getNewWeights(): 讓使用者輸入新配分 /
	 *************************************************************************/
	private double[] getNewWeights() {
		Scanner input = new Scanner(System.in);
		String[] prompt_string = new String[] { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		double[] new_weights = new double[5];

		System.out.println("輸入新配分");
		for (int i = 0; i < 5; ++i) {
			System.out.print("\t" + prompt_string[i] + "\t");
			new_weights[i] = input.nextFloat() / 100;
		}

		return new_weights;
	}

	/*************************************************************************
	 * /* private boolean checkWeights(float[] weights): 測試傳入的 weights 是曾合法 /
	 *************************************************************************/
	private boolean checkWeights(double[] weights) {
		float sum = 0;
		for (int i = 0; i < weights.length; ++i) {
			sum += weights[i];
		}
		if (sum == 1)
			return true;
		else
			return false;
	}
	
	/*************************************************************************
	/*	private void setWeights(float[] new_weights): 設定weights
	/*************************************************************************/
	private void setWeights(double[] newweights) {
		weights.clear();
		weights.add(newweights[0]);
		weights.add(newweights[1]);
		weights.add(newweights[2]);
		weights.add(newweights[3]);
		weights.add(newweights[4]);
	}
}
