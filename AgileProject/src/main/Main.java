package main;

/**
 * ################################################################## ��Grade
 * system ���ϥΪ�(�ǥ�)���o�L���`���Ztotal grade �αƦW rank. Total grade ���t��weights �Ӻ� ��
 * weights�i�Hupdate. Rank ��ܦ� total grade �b���Z�ǥͪ����ƱƧ�
 * 
 * Input file: ���Z�ǥͪ����� �Ҧp 962001044 ��v�� 87 86 98 88 87 962001051 ���§� 81 98 84 90
 * 93 �`�N data field names �p�U: ID name lab1 lab2 lab3 midTerm finalExam
 * ####################################################################
 */
public class Main {
	/**
	 * public static void main (String args[]) 
	 * 	call UI() �غc aUI
	 * 	loop1 until Q (Quit)
	 *		1.	promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
	 *		2.	checkID (ID) �� ID �O�_�b aGradeSystem��
	 *		3.	showWelcomeMsg (ID)      ex. Welcome���§�
	 *		4.	loop2 until E (Exit)
	 *			promptCommand() to prompt for inputCommand 
	 *   		end loop2
	 *	end loop1
	 *	3.showFinishMsg()           �����F(�P�W�������ϥΤ��P)
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
