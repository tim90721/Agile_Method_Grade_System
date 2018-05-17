package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

/** ***********************************************************************
	class UI (user interface) 

	���_prompt �ϥΪ� ID. ����ϥΪ� quit.	
	check �ϥΪ� ID , 
	showWelcomeMsg
    	���_prompt command. ���U�Ccommand����ϥΪ�exit
   		showGrade, 
   		showRank, 
   		updateWeights 
   		exit

	/*	Data Member:
	 	gradesystem
	 	
	/*  Constructor:
		UI() �غc�l �غc aGradeSystem
		
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
	UI() �غc�l throws NoSuchIDExceptions, NoSuchCommandExceptions
		1.call GradeSystems() to�غc aGradeSystem
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
		System.out.print("��J���O \n" +
						 "1) G ��ܦ��Z (Grade) \n" + 
						 "2) R ��ܱƦW (Rank) \n" +
						 "3) W ��s�t�� (Weight) \n" +
						 "4) E ���}��� (Exit) \n");
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
	time:     O(n)  n is  aGradeSystem �����Z�H��
		1.	�naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem�� 
		2.	if not, throw an object of NoSuchIDExceptions
		3.	�^�� true
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
		1.	��� "��JID��Q(�����ϥ�)?\r\n"
		2.	Ū�J�ϥΪ̿�J
		3.	�^�ǨϥΪ̿�J���r��
	--------------------------------------------------------------------- */
	public String promptID(){
		String id;
		Scanner scanner = new Scanner(System.in);
		System.out.print("��JID��Q(�����ϥ�)? \r\n");
		id = scanner.next();
		scanner.close();
		return id;
	}
	
	/** -------------------------------------------------------------------
	showFinishMsg () 
		���"�����F\r\n"
	--------------------------------------------------------------------- */
	public void showFinishMsg(){
		System.out.println("�����F");
	}
	
	/** -------------------------------------------------------------------
	showWelcomeMsg () 
		1.	�ھڨϥΪ̿�J��ID�qgradeSystem��Ū�X�m�W
		2.	��ܰT��"Welcome" + Ū�X���m�W  + "\r\n"
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
