import java.util.ArrayList;
import java.util.List;

/** BowlingGame Score calculator 
 *
 * @author CDT414 Student: ssi17005
 * @version 1.0 
 * @date 2016-11-24
 */


public class BowlingGame {

	/** BowlingGame Score calculator constructor which require string as input 
	 * @param game Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */	 
	
	String game; //global variable which gets the input string
	List<Frame> frame = new ArrayList<Frame>(); // global variable which will contain the list of frames
	
	public BowlingGame(String game){	
		//constructor for bowling game	    
		this.game=game;
	}
	
	
	
	public void getFrameList() {
		
		String[] frameArray = game.split("]");  // removes the closing bracket
		
		for(String frame: frameArray){	
			Frame Frame =new Frame();
			frame =frame.substring(1, frame.length()); // removes the opening bracket by creating a substring that removes the 0-index element which is the [-bracket
			String[] scoresArray = frame.split(","); // separates two elements
			
			
			if(scoresArray.length==2){
				Frame.setThrow1(Integer.parseInt(scoresArray[0]));
			    Frame.setThrow2(Integer.parseInt(scoresArray[1]));
			    this.frame.add(Frame);
			}
			else {
				Frame.setThrow1(Integer.parseInt(scoresArray[0]));
				this.frame.add(Frame);
			}
			
		}
		
	}
		
	
	
	/** getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is -1 
	 */
	public int getScore() {
		//if the string is on the right format
		if(verifyStringFormat(this.game)||verifyLastSpareStringFormat(this.game)||verifyLastStrikeStringFormat(this.game)) {
		getFrameList();
		int sum=0;
		
		for(int i=0; i<this.frame.size();i++){
			//open frame score calculator	
			if(checkType(this.frame.get(i))==0){
				
				sum = sum + this.frame.get(i).getThrow1() + this.frame.get(i).getThrow2();
				System.out.println(i);
				System.out.println(this.frame.get(i).getThrow1());
		        System.out.println(this.frame.get(i).getThrow2());	
			}
			
			//strike frame score calculator
			else if(checkType(this.frame.get(i))==1) {
				
				if(i==this.frame.size()-2) {
					if(this.frame.get(this.frame.size()-1).getThrow1()==10) {
					      sum = sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
					      return sum;
					}
					else {
						sum = sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
						return sum;
					}
				}	
					else {
						if(this.frame.get(i+1).getThrow1()==10){
							sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+2).getThrow1() + 10;
						}
						else {
						   sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
						}
					}
			}
			
			//spare frame score calculator
			else if(checkType(this.frame.get(i))==2){
				
				if(i==this.frame.size()-2){
					sum = sum +  10 + this.frame.get(i+1).getThrow1();
					System.out.println(sum);
					return sum;
					
				}
				else {
				sum= sum + 10 + this.frame.get(i+1).getThrow1();
				}
			}
		}
		
		System.out.println("Sum = " +sum);
		return sum;
	}
	
		else return -1; // otherwise return -1
	}
	
	
	// check if the frame is strike(return 1), spare(return 2) or open(return 0)
	public int checkType(Frame f) {
		if((f.getThrow1()+f.getThrow2()==10) && f.getThrow2()==0){	
			f.setStrike(true);
		    return 1;
		}
		else if((f.getThrow1()+f.getThrow2()==10) && f.getThrow2()!=0){
			f.setSpare(true);
			return 2;
		}
		else return 0;
	}

	
	
	//checks the format of the input string
	public boolean verifyStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),[0-9]\\]){10}");
	}
	//checks the format of the input string when the last frame was a strike
	public boolean verifyLastStrikeStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),[0-9]\\]){10}\\[([0-9]|10),([0-9]|10)\\]");
	}
	//checks the string input format when the last frame was a spare
	public boolean verifyLastSpareStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),[0-9]\\]){10}\\[([0-9]|10)\\]");
	}

	//checks if the frame is correct by checking if the sum of the two scores/throws is 10 
	public boolean checkSum(Frame frameTest) {
		if (frameTest.getThrow1() + frameTest.getThrow2() > 10) {
			return false;
		}
		else {
			return true;
		}
}
}