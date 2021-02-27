package StrategyPattern;

public class Context{
	private StrategyStats ss;
	
	public void setStrategyStats (StrategyStats ss) {
		this.ss = ss;
	}
	
	public void getStrategyStats() {
		ss.makeStats();
	}
}