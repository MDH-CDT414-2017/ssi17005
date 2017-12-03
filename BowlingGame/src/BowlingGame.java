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
	List<Frame> frame = new ArrayList<Frame>();
	String game;
	public BowlingGame(String g)
	{	

		this.game=g;
	
	}
		
	public void setFrame() {
		
			String[] frameArray = game.split("]");

			for (String frame : frameArray) {
				Frame f = new Frame();

				frame = frame.substring(1, frame.length());

				String[] scoresArray = frame.split(",");

				if (scoresArray.length == 2) {
					f.setThrow1(Integer.parseInt(scoresArray[0]));
					f.setThrow2(Integer.parseInt(scoresArray[1]));
					this.frame.add(f);
				} else {
					f.setThrow1(Integer.parseInt(scoresArray[0]));
					this.frame.add(f);
				}

			}
		
	}
	
	
	/** getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is -1 
	 */
	public int getScore() {
		
		if(verifyStringFormat(this.game) || verifyLastSpareStringFormat(this.game) || verifyLastStrikeStringFormat(this.game)) {
			setFrame();
		int sum=0;
		int it=0;
		for(int i=0; i<this.frame.size();i++){
			it++;
			int a,b;
			a=this.frame.get(i).getThrow1();
			b=this.frame.get(i).getThrow2();
			int c=a+b;
			if(c<=10) {
			if(checkType(this.frame.get(i))==0){
				
				if(it<11 )
					sum = sum + this.frame.get(i).getThrow1() + this.frame.get(i).getThrow2();
				else return -1;
			}
			else if(checkType(this.frame.get(i))==1) {
				if(i==this.frame.size()-2) {
					sum = sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
					return sum;
				}
				else if(i==this.frame.size()-1 ){
					return -1;}
					else {
						if(this.frame.get(i+1).getThrow1()==10){
							sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+2).getThrow1() + 10;
						}
						else
						sum= sum + this.frame.get(i+1).getThrow1() + this.frame.get(i+1).getThrow2() + 10;
					}
			}
			else {
				
				if(i==this.frame.size()-2){
					if(this.frame.get(i+1).getThrow2()!=0) 
					return -1;
					else  {
					sum = sum +  10 + this.frame.get(i+1).getThrow1();
					return sum;}
					}
				if(i==this.frame.size()-1 ){
					return -1;
					}
				else {
				sum= sum + 10 + this.frame.get(i+1).getThrow1();
				
			
			}
		}
	}
		
			else return -1;
	}
		return sum;
		
	}
		else return -1;
	}
		
	
	public int checkType(Frame f) {
		if(f.getThrow1()+f.getThrow2()==10 ){	
			if(f.getThrow2()==0)
			return 1;
		else {
			
				return 2;
			}
	}
		else return 0;
	}



	public boolean verifyStringFormat(String game) {
		if(game!=null)
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}");
		else return false;
	}
	
	public boolean verifyLastStrikeStringFormat(String game) {
		if(game!=null)
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10),([0-9]|10)\\]");
		else return false;
	}
	
	public boolean verifyLastSpareStringFormat(String game) {
		if(game!=null)
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10)\\]");
		else return false;
	}

}