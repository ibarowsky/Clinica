package StrategyPattern;

import java.sql.Date;

import com.itextpdf.text.Document;

public abstract class StrategyStats {
	protected static String status;
	protected static String adminName;
	protected Document doc;
	protected int npos;
	protected int nneg;
	protected static Date startDate;
	protected static Date endDate;
	
	public abstract void makeStats();
}
