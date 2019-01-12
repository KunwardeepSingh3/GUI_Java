import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * 
 * @author kunwardeepsingh
 *
 */
public class DateGUI extends JFrame	
{
	private JTextArea leftArea;
	private JTextArea rightArea;
	
	public DateGUI() {}		//Default constructor

	/**
	 * 
	 * @param title
	 * layout of Jframe
	 */
	public DateGUI(String title) {		//layout of Jframe
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1,2)); 
        this.setVisible(true);
        }		//Non-default constructor
	
		
	public void display_Gui() {
		this.pack();
		}		//display_Gui

	/**
	 *  
	 * @param file
	 * reads dates from file and display in JFrame
	 */
	public void displayDates(String file) {
		 Date212[] unsortedDates = new Date212[100];
		 Date212[] sortedDates = new Date212[100];
		 TextFileInput in = new TextFileInput(file);
		 int index = 0;
		 String line = "";
		 while((line = in.readLine()) != null) {	//keep reading line till line is null.
			 StringTokenizer st = new StringTokenizer(line, ",");	//read tokens with delimiter ",".
			 while(st.hasMoreTokens()) {	//keep reading till it has tokens.
				 String input_date = st.nextToken();
				 Date212 date = new Date212(input_date);	//Date212 constructor is invoked
				 if(date.date_check()) {	//date validation checking
					 unsortedDates[index] = date;	
					 sortedDates[index] = date;
					 index++;
					 }	//if
				 }	//while
			 }	//while
		 selectionSort(sortedDates, index);	//function is called to sort dates
		 
		 String leftPart = "Unsorted Dates\n\n";	//naming left side of GUI frame
		 String rightPart = "Sorted Dates\n\n";		//naming right side of GUI frame
		 
		 for(int i = 0; i < unsortedDates.length;i++){		//displaying unsorted dates in left part in form mm/dd/yyyy
			 if(unsortedDates[i] != null){
				 leftPart += (unsortedDates[i].toString() + "\n");
				 }		//if
			 else break;
			 }		//for
		 
		 for(int i = 0; i < sortedDates.length;i++){	//displaying sorted dates in right part in form mm/dd/yyyy
			 if(sortedDates[i] != null){
				 rightPart += (sortedDates[i].toString() + "\n");
				 }		//if
			 else break;
			 }		//for
		
		 this.leftArea = new JTextArea(leftPart, 10, 20);
		 this.rightArea = new JTextArea(rightPart, 10, 20);
		 JPanel jp = new JPanel();
	      // Add the JTextArea's to the content pane
		 jp.add(this.leftArea);
		 jp.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.LINE_START);		//separator
		 jp.add(this.rightArea);
		 this.getContentPane().add(jp);
		 }		//display_Dates

	/**
	 *  
	 * @param array
	 * @param length
	 * sorts the dates
	 */
	private static void selectionSort(Date212[] array, int length) {		//sorting the dates
		 for ( int i = 0; i < length - 1; i++ ) {
			 int indexLowest = i;
			 for ( int j = i + 1; j < length; j++ )
				 if ( array[j].compareTo(array[indexLowest]) < 0 )		//use of compareTo method from Date212 class
					 indexLowest = j;
			 if ( array[indexLowest] != array[i] ) {
				 Date212 temp = array[indexLowest];		//swapping and sorting
				 array[indexLowest] = array[i];
				 array[i] = temp;
				 }  // if
			 } // for i
		 } // method selectionSort
	 }		//class 
