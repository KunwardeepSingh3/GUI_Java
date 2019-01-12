/**
 * 
 * @author kunwardeepsingh
 *
 */
public class Date212 {
	private int year;
	private int month;
	private int day;
	/**
	 * 
	 * @param str
	 */
	public Date212(String str) {	//convert subString to integer and store in the variables.
		year = Integer.parseInt(str.substring(0, 4));	
		month = Integer.parseInt(str.substring(4, 6));
		day = Integer.parseInt(str.substring(6, 8));
	}	//Non-default constructor 
	
	/**
	 * 
	 * @return
	 * returns true or false if date is valid.
	 */
	boolean date_check() {	//check invalid date 
		if(month <= 0 || month >= 13 || day <= 0 || day > 31) 
			return false;
		else return true;
	}	//date_check

	/**
	 * 
	 * @param other
	 * @return integer
	 * compare the dates. 
	 */
	public int compareTo(Date212 other){	
		if(this.year < other.year)return -1;
		else if(this.year > other.year)return 1;
		else if(this.month < other.month)return -1;
		else if(this.month > other.month)return 1;
		else if(this.day < other.day)return -1;
		else if(this.day > other.day)return 1;
		else return 0;
		}
	
	public String toString() {	//formatting date in order mm/dd/yyyy.
		String str = "";
		if(month  < 10)
			str += "0" + month;
		else
			str += month;
		str += "/";
		if(day < 10)
			str += "0" + day;
		else
			str += day;
		str += "/" + year;
		return str;
	}	//toString

}	//class
