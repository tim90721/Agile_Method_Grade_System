package main;

/**
 * ################################################################## 本Grade
 * system 讓使用者(學生)取得他的總成績total grade 及排名 rank. Total grade 基於配分weights 來算 而
 * weights可以update. Rank 表示此 total grade 在全班學生的分數排序
 * 
 * Input file: 全班學生的分數 例如 962001044 凌宗廷 87 86 98 88 87 962001051 李威廷 81 98 84 90
 * 93 注意 data field names 如下: ID name lab1 lab2 lab3 midTerm finalExam
 * ####################################################################
 */
public class Main {
	/**
	 * public static void main (String args[]) 
	 * 	call UI() 建構 aUI
	 * 	loop1 until Q (Quit)
	 *		1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
	 *		2.	checkID (ID) 看 ID 是否在 aGradeSystem內
	 *		3.	showWelcomeMsg (ID)      ex. Welcome李威廷
	 *		4.	loop2 until E (Exit)
	 *			promptCommand() to prompt for inputCommand 
	 *   		end loop2
	 *	end loop1
	 *	3.showFinishMsg()           結束了(與上面結束使用不同)
	 *
	 */
	public static void main(String args[]) {
		UI aUI = new UI();
		String id;
		while (true) {
			id = aUI.promptID();
			if (id.equals("Q") || id.equals("q"))
				break;
			try {
				aUI.checkID(id);
				aUI.showWelcomeMsg(id);
				while (true) {
					try {
						if (aUI.promptCommand().equals("Exit"))
							break;
					}
					catch (NoSuchCommandExceptions ex) {
						System.out.println(ex.getMessage());
					}
				}
			} catch (NoSuchIDExceptions ex) {
				System.out.println(ex.getMessage());
			}
		}
		aUI.showFinishMsg();
	}
}
