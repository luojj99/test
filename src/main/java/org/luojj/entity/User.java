package org.luojj.entity;

import java.util.Date;

import org.luojj.baseclass.BaseBean;

public class User extends BaseBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.phone_number
     *
     * @mbggenerated
     */
    private String phoneNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.login_password
     *
     * @mbggenerated
     */
    private String loginPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id_card_number
     *
     * @mbggenerated
     */
    private String idCardNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.trading_password
     *
     * @mbggenerated
     */
    private String tradingPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.profile_photo
     *
     * @mbggenerated
     */
    private String profilePhoto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.real_name
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.age
     *
     * @mbggenerated
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.marriage
     *
     * @mbggenerated
     */
    private String marriage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.income_level
     *
     * @mbggenerated
     */
    private String incomeLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.investment_style
     *
     * @mbggenerated
     */
    private String investmentStyle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.risk_score
     *
     * @mbggenerated
     */
    private Double riskScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.bank_card_number
     *
     * @mbggenerated
     */
    private String bankCardNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.phone_number
     *
     * @return the value of user_info.phone_number
     *
     * @mbggenerated
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.phone_number
     *
     * @param phoneNumber the value for user_info.phone_number
     *
     * @mbggenerated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_name
     *
     * @return the value of user_info.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_name
     *
     * @param userName the value for user_info.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.login_password
     *
     * @return the value of user_info.login_password
     *
     * @mbggenerated
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.login_password
     *
     * @param loginPassword the value for user_info.login_password
     *
     * @mbggenerated
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gender
     *
     * @return the value of user_info.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gender
     *
     * @param gender the value for user_info.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id_card_number
     *
     * @return the value of user_info.id_card_number
     *
     * @mbggenerated
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id_card_number
     *
     * @param idCardNumber the value for user_info.id_card_number
     *
     * @mbggenerated
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber == null ? null : idCardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.trading_password
     *
     * @return the value of user_info.trading_password
     *
     * @mbggenerated
     */
    public String getTradingPassword() {
        return tradingPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.trading_password
     *
     * @param tradingPassword the value for user_info.trading_password
     *
     * @mbggenerated
     */
    public void setTradingPassword(String tradingPassword) {
        this.tradingPassword = tradingPassword == null ? null : tradingPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.profile_photo
     *
     * @return the value of user_info.profile_photo
     *
     * @mbggenerated
     */
    public String getProfilePhoto() {
        return profilePhoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.profile_photo
     *
     * @param profilePhoto the value for user_info.profile_photo
     *
     * @mbggenerated
     */
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.create_time
     *
     * @return the value of user_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.create_time
     *
     * @param createTime the value for user_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.real_name
     *
     * @return the value of user_info.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.real_name
     *
     * @param realName the value for user_info.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.age
     *
     * @return the value of user_info.age
     *
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.age
     *
     * @param age the value for user_info.age
     *
     * @mbggenerated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.marriage
     *
     * @return the value of user_info.marriage
     *
     * @mbggenerated
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.marriage
     *
     * @param marriage the value for user_info.marriage
     *
     * @mbggenerated
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.income_level
     *
     * @return the value of user_info.income_level
     *
     * @mbggenerated
     */
    public String getIncomeLevel() {
        return incomeLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.income_level
     *
     * @param incomeLevel the value for user_info.income_level
     *
     * @mbggenerated
     */
    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel == null ? null : incomeLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.investment_style
     *
     * @return the value of user_info.investment_style
     *
     * @mbggenerated
     */
    public String getInvestmentStyle() {
        return investmentStyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.investment_style
     *
     * @param investmentStyle the value for user_info.investment_style
     *
     * @mbggenerated
     */
    public void setInvestmentStyle(String investmentStyle) {
        this.investmentStyle = investmentStyle == null ? null : investmentStyle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.risk_score
     *
     * @return the value of user_info.risk_score
     *
     * @mbggenerated
     */
    public Double getRiskScore() {
        return riskScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.risk_score
     *
     * @param riskScore the value for user_info.risk_score
     *
     * @mbggenerated
     */
    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.bank_card_number
     *
     * @return the value of user_info.bank_card_number
     *
     * @mbggenerated
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.bank_card_number
     *
     * @param bankCardNumber the value for user_info.bank_card_number
     *
     * @mbggenerated
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }
}