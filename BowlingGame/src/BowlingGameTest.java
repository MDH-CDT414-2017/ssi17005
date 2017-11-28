/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import org.junit.Test;

import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
        
	/** test01 
	 * 	
	 *  If no game is provided, score should be -1 (error)   
	 */	   
	
	
	
	public void testStringFormat() {
        BowlingGame bowlingGame = new BowlingGame("");
        assertEquals(-1, bowlingGame.getScore());
    }	

	public void testStringFormat2()	{
		BowlingGame bowlingGame = new BowlingGame("[5,5][3,5]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	
	@Test
	public void test01() {
       BowlingGame bowlingGame = new BowlingGame("[1,5][2,6]");
//        assertEquals(0, bowlingGame.checkType());
       assertEquals(14, bowlingGame.getScore());
    }	
	
	@Test
	public void test2() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, game1.getScore());
	}
	
	public void testOpenFrame() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, bowlingGame.getScore());
}
	@Test
	public void testStrike() {
		
		BowlingGame game1 = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, game1.getScore());
	}
	@Test
	public void testMultipleStrikes() {
		
		BowlingGame game1 = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(112, game1.getScore());
	}
	@Test
	public void testSpare() {
		
		BowlingGame game1 = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, game1.getScore());
	}
	@Test
	public void testMultipleSpares() {
		
		BowlingGame game1 = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(98, game1.getScore());
	}
	@Test
	public void testStrikeSpare() {
		
		BowlingGame game1 = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(103, game1.getScore());
	}
	@Test
	public void testLastSpare() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		assertEquals(90, game1.getScore());
	}
	@Test
	public void testLastStrike() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		assertEquals(92, game1.getScore());
	}
	@Test
	public void testLastSpareStrike() {
		
		BowlingGame game1 = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(93, game1.getScore());
	}
	@Test
	public void testMaximum() {
		
		BowlingGame game1 = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, game1.getScore());
	}
	
	
	public void testDoubleStrike() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        
        assertEquals(112, bowlingGame.getScore());
    }
	
	public void testDoubleSpare() {
        BowlingGame bowlingGame = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        
        assertEquals(98, bowlingGame.getScore());
    }
	
	
	public void testLastDoubleSpare() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,2][2,8][7]");
        
        assertEquals(93, bowlingGame.getScore());
    }
	
	public void testLastDoubleStrike() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][10,0][10,0][7,2]");
        
        assertEquals(110, bowlingGame.getScore());
    }
	
	public void testStringWithNegativeNumbers() {
		 BowlingGame bowlingGame = new BowlingGame("[10,0][-4,6][7,2][3,6][-4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testLastStrikeStringWithNegativeNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][-3,6][4,4][5,3][3,3][-4,5][8,1][2,6][10,10]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	
	public void testLastSpareStringWithNegativeNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][10]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testWrongFrame() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,6][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testWrongLastStrike() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][20,20]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testWrongLastSpare() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][20]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testWrongFrameNumber() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	public void testWrongFrameNumber1() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][10,3][10]");
		assertEquals(-1,bowlingGame.getScore());
		
	}
	
	@Test
	public void testString()
	{
		BowlingGame game1 = new BowlingGame("[2,3][3,3][4,5][2,4][4,3][3,4][5,5][3,4][2,1][5,3]");
		 //assertEquals(true, game1.validInput("[2,3][3,3][4,5][2,4][4,3][3,4][5,5][3,4][2,1][5,3]"));
	}
	
}