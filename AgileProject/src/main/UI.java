package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

/** ***********************************************************************
	class UI (user interface) 

	不斷prompt 使用者 ID. 直到使用者 quit.	
	check 使用者 ID , 
	showWelcomeMsg
    	不斷prompt command. 做下列command直到使用者exit
   		showGrade, 
   		showRank, 
   		updateWeights 
   		exit

	/*	Data Member:
	 	gradesystem
	 	
	/*  Constructor:
		UI() 建構子 建構 aGradeSystem
		
	/*	Public Method:
		checkID(ID)	
		promptCommand()
		promptID()
		showFinishMsg()
		showWelcomeMsg()
************************************************************************ */
public class UI {
	GradeSystem aGradeSystem;
	String id;
	
	/** -------------------------------------------------------------------
	UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
		1.call GradeSystems() to建構 aGradeSystem
	--------------------------------------------------------------------- */
	public UI(){
		aGradeSystem = new GradeSystem();
	}
	
	/** -------------------------------------------------------------------
	promptCommand () throws NoSuchCommandExceptions
	return: inputCommand  G (Grade),R (Rank), W (Weights), or E (Exit)
	
	1. prompt user for inputCommand
	2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
	 		throws an object of NoSuchCommandException  end if
	3. if inputCommand is E (Exit) then break
		else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
	--------------------------------------------------------------------- */
	public String promptCommand() throws NoSuchCommandExceptions{
		String command;
		Scanner scanner = new Scanner(System.in);
		String outputCommand = "";
		System.out.print("輸入指令 \n" +
						 "1) G 顯示成績 (Grade) \n" + 
						 "2) R 顯示排名 (Rank) \n" +
						 "3) W 更新配分 (Weight) \n" +
						 "4) E 離開選單 (Exit) \n");
		command = scanner.next();
		switch(command){
		case "G":
		case "g":
			System.out.println(aGradeSystem.showGrade(id));
			outputCommand = "Grade";
			break;
		case "R":
		case "r":
			System.out.println(aGradeSystem.showRank(id));
			outputCommand = "Rank";
			break;
		case "W":
		case "w":
			aGradeSystem.updateWeight();
			outputCommand = "Weight";
			break;
		case "E":
		case "e":
			outputCommand = "Exit";
			break;
		default:
			scanner.close();
			throw new NoSuchCommandExceptions(command);
		}
		scanner.close();
		return outputCommand;
	}
	
	/** -------------------------------------------------------------------
	checkID (ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem 內全班人數
		1.	要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內 
		2.	if not, throw an object of NoSuchIDExceptions
		3.	回傳 true
	--------------------------------------------------------------------- */
	public boolean checkID(String ID) throws NoSuchIDExceptions{
		if(aGradeSystem.containsID(id))
			return true;
		else
			throw new NoSuchIDExceptions(id);
	}
	
	/** -------------------------------------------------------------------
	prompoID () return String
	return ID or Q
		1.	顯示 "輸入ID或Q(結束使用)?\r\n"
		2.	讀入使用者輸入
		3.	回傳使用者輸入之字串
	--------------------------------------------------------------------- */
	public String promptID(){
		String id;
		Scanner scanner = new Scanner(System.in);
		System.out.print("輸入ID或Q(結束使用)? \r\n");
		id = scanner.next();
		scanner.close();
		return id;
	}
	
	/** -------------------------------------------------------------------
	showFinishMsg () 
		顯示"結束了\r\n"
	--------------------------------------------------------------------- */
	public void showFinishMsg(){
		System.out.println("結束了");
	}
	
	/** -------------------------------------------------------------------
	showWelcomeMsg () 
		1.	根據使用者輸入的ID從gradeSystem裡讀出姓名
		2.	顯示訊息"Welcome" + 讀出的姓名  + "\r\n"
	--------------------------------------------------------------------- */
	public String showWelcomeMsg(String ID){
		String name;
		String message;
		name = aGradeSystem.getGradeName(id);
		message = "Welcome " + name;
		System.out.println(message);
		return message;
	}
}
