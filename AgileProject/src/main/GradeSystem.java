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
 * /* class GradeSystem /* �i�� GradeSystem �������ާ@ /* /* Data Member: /* grades:
 * LinkedList, �x�s a list of student grades. /* Constructor: /* GradeSystems() /*
 * Public Method: /* containsID(id): boolean, ��aList�O�_�t��id /* showGrade(id):
 * boolean, ��ܦ�id������, �Yid���s�b�h�^��false /* showRank(id): boolean, ��ܦ�id���ƦW,
 * �Yid���s�b�h�^��false /* updateWeights(): ��s���ưt�� /* getWeight(index):
 * �d���index��weight /
 *************************************************************************/
public class GradeSystem {
	private LinkedList<Grades> grades;
	private ArrayList<Double> weights;
	private static final String infile = "Input.txt";

	/**
	 * ----------------------------------------------------------------------
	 * /*public GradeSystems () //�غc�l
	 * 
	 * /*1. �}�� input file ��gradeInput.txt�� /*2. ��Java LinkedList�غcan empty list of
	 * grades�s aList /*3. read line /*4. while not endOfFile /*1. call Grades()
	 * �غcaGrade /*2. �� Java Scanner �� scan line ��U���s�JaGrade /*3.
	 * aGrade.calculateTotalGrade(weights) �^��aTotalGrade�⥦�s�JaGrade /*4. �� aGrade �s�J
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
	 * public boolean containsID(String id) /* �� id �O�_�t�b aGradeSystem�� /* �s�b�h�^��
	 * true�A���s�b�h�^�� false
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
	 * public boolean showGrade(String id) /* �Yid���s�b�h�^��false /* ��ܦ� id ���U������
	 * /**----------------------------------------------------------------------
	 */
	public String showGrade(String ID) {
		Grades grade = getGradeFromList(ID);
		if (grade == null)
			return "Input Error";
		String message = grade.getName() + "���Z:lab1:\t" + grade.getLab1() + "\n" + "lab2:\t" + grade.getLab2() + "\n"
				+ "lab3:\t" + grade.getLab3() + "\n" + "midTerm:\t" + grade.getMidTerm() + "\n" + "finalExam:\t"
				+ grade.getFinal() + "\n" + "total grade:\t" + grade.calculateTotalGrade(weights) + "\n";
		return message;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public boolean showRank(String id) /* 1. ���o�o ID �� theTotalGrade /* 2. �Orank ��
	 * 1 /* 3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank�[1(�h1�W)
	 * end loop /* 4. show �o ID �� rank
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
		message = theGrade.getName() + "�ƦW��" + rank;
		return message;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public void updateWeights() /* showOldWeights(): ��ܭ쥻���t�� /* getNewWeights():
	 * ���ϥΪ̿�J�s�t�� /* �T�{��J��weights�M�O�_��1 /* if(true) /* �T�{��J /*
	 * setWeights(weights):�T�{���sweights /* Loop: ���s�p��Ҧ�id��TotalGrade /* else ��ܿ�J���~
	 * /**----------------------------------------------------------------------
	 */
	public boolean updateWeight() {
		showOldWeight();
		double[] new_weights = getNewWeights();

		if (this.checkWeights(new_weights)) {
			System.out.println("�нT�{�s�t��");
			this.showWeight(new_weights);

			System.out.print("�H�W���T��? Y (Yes) �� N (No)");
			Scanner input = new Scanner(System.in);
			String in = input.next();
			if (in.equals("Y")) {
				setWeights(new_weights);
				for (Grades aGrade : grades)
					aGrade.calculateTotalGrade(this.weights);
			}
		} else {
			System.out.println("�t����J���~�G�񭫬ۥ[����1");
			return false;
		}
		return true;
	}

	/**
	 * ---------------------------------------------------------------------- /*
	 * public Double getWeight(int index) /* �ھ�index�d��s�bweights�̤��P���Z��weight
	 * /**----------------------------------------------------------------------
	 */
	public Double getWeight(int index) {
		return weights.get(index);
	}

	/*************************************************************************
	 * /* public String getGradeName(String id) /* ���o id �ҹ������W�١A�Y id ���s�b�h�^�� null /
	 *************************************************************************/
	public String getGradeName(String ID) {
		System.out.println(ID);
		Grades grade = getGradeFromList(ID);
		return grade.getName();
	}

	/*************************************************************************
	 * /* private Grades transferLineToGrades(String line): /* �NŪ�쪺��Ʀ�: 962001044
	 * ��v�� 87 86 98 88 87 �i����� /* �s�JaGrade�����A�i��^�ǡC /
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
	 * /* private Grades getGradeFromList(String id): /* �� aList ���� id ��M������ Grades
	 * �^��, /* �Y���s�b�h�^�� null /
	 *************************************************************************/
	private Grades getGradeFromList(String ID) {
		for (Grades grade : grades) {
			if (grade.getID().equals(ID))
				return grade;
		}
		return null;
	}

	/*************************************************************************
	 * /* private void showOldWeight(): ��ܭ쥻���t�� /
	 *************************************************************************/
	private void showOldWeight() {
		System.out.println("�°t��");
		this.showWeight(this.weights);
	}

	/*************************************************************************
	 * /* private void showWeight(float[] weights): �̵��w�Ѽ���ܰt�� /
	 *************************************************************************/
	private void showWeight(List<Double> weights) {
		System.out.println("\tlab1\t" + Math.round(weights.get(0) * 100) + "%\n" + "\tlab2\t"
				+ Math.round(weights.get(1) * 100) + "%\n" + "\tlab3\t" + Math.round(weights.get(2) * 100) + "%\n"
				+ "\tmid-term\t" + Math.round(weights.get(3) * 100) + "%\n" + "\tfinal exam\t"
				+ Math.round(weights.get(4) * 100) + "%");
	}
	
	/*************************************************************************
	/*	private void showWeight(float[] weights): �̵��w�Ѽ���ܰt��
	/*************************************************************************/
	private void showWeight(double[] weights) {
		System.out.println( "\tlab1\t" + Math.round(weights[0]*100) + "%\n" +
							"\tlab2\t" + Math.round(weights[1]*100) + "%\n" +
							"\tlab3\t" + Math.round(weights[2]*100) + "%\n" +
							"\tmid-term\t" + Math.round(weights[3]*100) + "%\n" +
							"\tfinal exam\t" + Math.round(weights[4]*100) + "%");
	}
	

	/*************************************************************************
	 * /* private float[] getNewWeights(): ���ϥΪ̿�J�s�t�� /
	 *************************************************************************/
	private double[] getNewWeights() {
		Scanner input = new Scanner(System.in);
		String[] prompt_string = new String[] { "lab1", "lab2", "lab3", "mid-term", "final exam" };
		double[] new_weights = new double[5];

		System.out.println("��J�s�t��");
		for (int i = 0; i < 5; ++i) {
			System.out.print("\t" + prompt_string[i] + "\t");
			new_weights[i] = input.nextFloat() / 100;
		}

		return new_weights;
	}

	/*************************************************************************
	 * /* private boolean checkWeights(float[] weights): ���նǤJ�� weights �O���X�k /
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
	/*	private void setWeights(float[] new_weights): �]�wweights
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
