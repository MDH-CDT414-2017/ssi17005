
public class Frame {

	private int throw1;
	private int throw2;
	
	private boolean strike;
	private boolean spare;
	
	public boolean isStrike() {
		return strike;
	}
	public void setStrike(boolean strike) {
		this.strike = strike;
	}
	public boolean isSpare() {
		return spare;
	}
	public void setSpare(boolean spare) {
		this.spare = spare;
	}
	public int getThrow1() {
		return throw1;
	}
	public void setThrow1(int throw1) {
		this.throw1 = throw1;
	}
	public int getThrow2() {
		return throw2;
	}
	public void setThrow2(int throw2) {
		this.throw2 = throw2;
	}
	@Override
	public String toString() {
		return "Frame [throw1=" + throw1 + ", throw2=" + throw2 + "]";
	}


}
