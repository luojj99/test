package org.luojj.core;

import org.luojj.entity.User;

public class RiskScorer {
	private  Integer age;
	private  String marriage;
	private  String incomeLevel;
	private  String investmentStyle;
	private  String gender;
	private  double riskScore = 0;
	private final double AGE_WEIGHT = 0.15;
	private final double INCOME_WEIGHT = 0.25;
	private final double MARRIAGE_WEIGHT = 0.15;
	private final double GENDER_WEIGHT = 0.1;
	private final double INVEST_WEIGHT = 0.35;
	
	public void  init(User user) {
		this.age = user.getAge();
		this.marriage = user.getMarriage();
		this.incomeLevel = user.getIncomeLevel();
		this.investmentStyle = user.getInvestmentStyle();
		this.gender = user.getGender();
	}
	
	public double  scoring(User user) {
		init(user);
		riskScore=getAgeScore(age)+getMarriageScore(marriage)+getIncomeScore(incomeLevel)+
					getGenderScore(gender)+getInvestScore(investmentStyle);
		return riskScore;
	}

	public double getInvestScore(String investmentStyle) {
		double investScore = 0;
		if (incomeLevel.equals("保守型")) {
			investScore = 5 * INVEST_WEIGHT;
		}
		if (incomeLevel.equals("稳健型")) {
			investScore = 10 * INVEST_WEIGHT;
		}
		if (incomeLevel.equals("")) {
			investScore = 20 * INVEST_WEIGHT;
		}
		if (incomeLevel.equals("")) {
			investScore = 30 * INVEST_WEIGHT;
		}
		if (incomeLevel.equals("2")) {
			investScore = 35 * INVEST_WEIGHT;
		}

		return investScore;
	}

	public double getGenderScore(String gender) {
		double genderScore = 0;
		if (incomeLevel.equals("男")) {
			genderScore = 60 * GENDER_WEIGHT;
		}
		if (incomeLevel.equals("女")) {
			genderScore = 40 * GENDER_WEIGHT;
		}
		return genderScore;
	}

	public double getMarriageScore(String marriage) {
		double marriageScore = 0;
		if (incomeLevel.equals("未婚")) {
			marriageScore = 40 * MARRIAGE_WEIGHT;
		}
		if (incomeLevel.equals("已婚")) {
			marriageScore = 60 * MARRIAGE_WEIGHT;
		}

		return marriageScore;
	}

	public double getIncomeScore(String incomeLevel) {
		double incomeScore = 0;
		if (incomeLevel.equals("0-5k")) {
			incomeScore = 10 * INCOME_WEIGHT;
		}
		if (incomeLevel.equals("5-1w")) {
			incomeScore = 20 * INCOME_WEIGHT;
		}
		if (incomeLevel.equals("1w-2w")) {
			incomeScore = 30 * INCOME_WEIGHT;
		}
		if (incomeLevel.equals("2w-5w")) {
			incomeScore = 40 * INCOME_WEIGHT;
		}

		return incomeScore;
	}

	public double getAgeScore(int age) {
		double ageScore = 0;
		if (age >= 18 && age <= 23) {
			ageScore = 15 * AGE_WEIGHT;
		}
		if (age >= 24 && age <= 30) {
			ageScore = 20 * AGE_WEIGHT;
		}
		if (age >= 31 && age <= 40) {
			ageScore = 25 * AGE_WEIGHT;
		}
		if (age >= 41 && age <= 50) {
			ageScore = 30 * AGE_WEIGHT;
		}
		if (age >= 51) {
			ageScore = 10 * AGE_WEIGHT;
		}

		return ageScore;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public String getInvestmentStyle() {
		return investmentStyle;
	}

	public void setInvestmentStyle(String investmentStyle) {
		this.investmentStyle = investmentStyle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(double riskScore) {
		this.riskScore = riskScore;
	}

}
