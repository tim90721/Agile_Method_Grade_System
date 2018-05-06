package main;

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
	GradeSystem gradeSystem;
	
	/** -------------------------------------------------------------------
	UI() �غc�l throws NoSuchIDExceptions, NoSuchCommandExceptions
		try 
			1.call GradeSystems() to�غc aGradeSystem
	
			2.loop1 until Q (Quit)
				1.	promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
				2.	checkID (ID) �� ID �O�_�b aGradeSystem��
				3.	showWelcomeMsg (ID)      ex. Welcome���§�
				4.	loop2 until E (Exit)
					promptCommand() to prompt for inputCommand 
	    		end loop2
			end loop1
			3.showFinishMsg()           �����F(�P�W�������ϥΤ��P)
		end try
		finally {}
	--------------------------------------------------------------------- */
	public UI(){
		gradeSystem = new GradeSystem();
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
	public String promptCommand(){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	checkID (ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem �����Z�H��
		1.	�naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem�� 
		2.	if not, throw an object of NoSuchIDExceptions
		3.	�^�� true
	--------------------------------------------------------------------- */
	public boolean checkID(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	prompoID () return String
	return ID or Q
		1.	��� "��JID��Q(�����ϥ�)?\r\n"
		2.	Ū�J�ϥΪ̿�J
		3.	�^�ǨϥΪ̿�J���r��
	--------------------------------------------------------------------- */
	public String promptID(){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	showFinishMsg () 
		���"�����F\r\n"
	--------------------------------------------------------------------- */
	public void showFinishMsg(){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	showWelcomeMsg () 
		1.	�ھڨϥΪ̿�J��ID�qgradeSystem��Ū�X�m�W
		2.	��ܰT��"Welcome" + Ū�Ѫ��m�W  + "\r\n"
	--------------------------------------------------------------------- */
	public void showWelcomMsg(){
		throw new UnsupportedOperationException();
	}
}
