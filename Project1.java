
/**
 * 
 * @author kunwardeepsingh
 *
 */
public class Project1 {	
	/**
	 * 
	 * @param args
	 * main program
	 */
	public static void main(String[] args) {
		 DateGUI gui = new DateGUI("Date list");	//Jframe with title "Date list"
		 gui.displayDates("lab6Input.txt");		//calling display_Dates function from DateGUI class 
		 //it reads from text file and display in Jframe in two  columns, sorted and unsorted Dates 
		 gui.display_Gui();		//calling function
		 }		//main
}		//class
