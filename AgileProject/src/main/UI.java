package main;

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
	GradeSystem gradeSystem;
	
	/** -------------------------------------------------------------------
	UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
		try 
			1.call GradeSystems() to建構 aGradeSystem
	
			2.loop1 until Q (Quit)
				1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
				2.	checkID (ID) 看 ID 是否在 aGradeSystem內
				3.	showWelcomeMsg (ID)      ex. Welcome李威廷
				4.	loop2 until E (Exit)
					promptCommand() to prompt for inputCommand 
	    		end loop2
			end loop1
			3.showFinishMsg()           結束了(與上面結束使用不同)
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
	time:     O(n)  n is  aGradeSystem 內全班人數
		1.	要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內 
		2.	if not, throw an object of NoSuchIDExceptions
		3.	回傳 true
	--------------------------------------------------------------------- */
	public boolean checkID(String ID){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	prompoID () return String
	return ID or Q
		1.	顯示 "輸入ID或Q(結束使用)?\r\n"
		2.	讀入使用者輸入
		3.	回傳使用者輸入之字串
	--------------------------------------------------------------------- */
	public String promptID(){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	showFinishMsg () 
		顯示"結束了\r\n"
	--------------------------------------------------------------------- */
	public void showFinishMsg(){
		throw new UnsupportedOperationException();
	}
	
	/** -------------------------------------------------------------------
	showWelcomeMsg () 
		1.	根據使用者輸入的ID從gradeSystem裡讀出姓名
		2.	顯示訊息"Welcome" + 讀書的姓名  + "\r\n"
	--------------------------------------------------------------------- */
	public void showWelcomMsg(){
		throw new UnsupportedOperationException();
	}
}
