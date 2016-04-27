package org.luojj.core;

import java.math.BigDecimal;

import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.Stock;
import org.luojj.entity.User;


public class InvestSystem {
	public static BigDecimal FUND_RATIO;
	public static BigDecimal BOND_RATIO;
	public static BigDecimal STOCK_RATIO;
	
	/**
	 * 推荐投资组合<p>
	 * InvestSystem.FUND_RATIO 基金比例<br>
	 * InvestSystem.BOND_RATIO 债券比例<br>
	 * InvestSystem.STOCK_RATIO 股票比例<br>
	 * @param user
	 */
	public static void  recommend(User user){
		RiskScorer riskScorer = new RiskScorer();
		double rickScore=riskScorer.scoring(user);
		if (rickScore>0&&rickScore<=10) {
			setInvestRatio(0.2, 0.3, 0.5);
		}
		if (rickScore>10&&rickScore<=20) {
			setInvestRatio(0.25, 0.3, 0.45);
		}
		if (rickScore>20&&rickScore<=30) {
			setInvestRatio(0.3, 0.3, 0.4);
		}
		if (rickScore>30&&rickScore<=40) {
			setInvestRatio(0.35, 0.35, 0.3);
		}
		if (rickScore>40&&rickScore<=50) {
			setInvestRatio(0.4, 0.35, 0.25);
		}
		if (rickScore>50&&rickScore<=60) {
			setInvestRatio(0.45, 0.35, 0.2);
		}
		if (rickScore>60&&rickScore<=70) {
			setInvestRatio(0.5, 0.35, 0.15);
		}
		if (rickScore>70&&rickScore<=80) {
			setInvestRatio(0.55, 0.35, 0.1);
		}
		if (rickScore>80&&rickScore<90) {
			setInvestRatio(0.6, 0.35, 0.5);
		}
		if (rickScore>90&&rickScore<=100) {
			setInvestRatio(0.65, 0.35, 0);
		}
	}
	
	public static void setInvestRatio(double stock,double fund,double bond){
		InvestSystem.STOCK_RATIO=new BigDecimal(String.valueOf(stock));
		InvestSystem.FUND_RATIO=new BigDecimal(String.valueOf(fund));
		InvestSystem.BOND_RATIO=new BigDecimal(String.valueOf(bond));
		
	}
	
	
//	public static void chooseInvestGroup(){
//		Stock stock=stockMapper.selectByPrimaryKey(11L);
//		stock.setInvestRate(InvestSystem.STOCK_RATIO);
//		System.out.println(33);
//		Bond bond =bondMapper.selectByPrimaryKey(31L);;
//		bond.setInvestRate(InvestSystem.BOND_RATIO);
//		Fund fund =fundMapper.selectByPrimaryKey(21L);
//		fund.setInvestRate(InvestSystem.FUND_RATIO);
//	}
	
	
}
