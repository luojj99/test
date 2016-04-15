package org.luojj.entity;

import java.util.Date;

import org.luojj.baseclass.BasicObject;

public class BankCard extends BasicObject {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.phone_number
     *
     * @mbggenerated
     */
    private String phoneNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.bank_card_number
     *
     * @mbggenerated
     */
    private String bankCardNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.bank_card_type
     *
     * @mbggenerated
     */
    private String bankCardType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.bank_phone_number
     *
     * @mbggenerated
     */
    private String bankPhoneNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.bank_name
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card.real_name
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.phone_number
     *
     * @return the value of bank_card.phone_number
     *
     * @mbggenerated
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.phone_number
     *
     * @param phoneNumber the value for bank_card.phone_number
     *
     * @mbggenerated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.bank_card_number
     *
     * @return the value of bank_card.bank_card_number
     *
     * @mbggenerated
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.bank_card_number
     *
     * @param bankCardNumber the value for bank_card.bank_card_number
     *
     * @mbggenerated
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.bank_card_type
     *
     * @return the value of bank_card.bank_card_type
     *
     * @mbggenerated
     */
    public String getBankCardType() {
        return bankCardType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.bank_card_type
     *
     * @param bankCardType the value for bank_card.bank_card_type
     *
     * @mbggenerated
     */
    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType == null ? null : bankCardType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.bank_phone_number
     *
     * @return the value of bank_card.bank_phone_number
     *
     * @mbggenerated
     */
    public String getBankPhoneNumber() {
        return bankPhoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.bank_phone_number
     *
     * @param bankPhoneNumber the value for bank_card.bank_phone_number
     *
     * @mbggenerated
     */
    public void setBankPhoneNumber(String bankPhoneNumber) {
        this.bankPhoneNumber = bankPhoneNumber == null ? null : bankPhoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.bank_name
     *
     * @return the value of bank_card.bank_name
     *
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.bank_name
     *
     * @param bankName the value for bank_card.bank_name
     *
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.create_time
     *
     * @return the value of bank_card.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.create_time
     *
     * @param createTime the value for bank_card.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card.real_name
     *
     * @return the value of bank_card.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card.real_name
     *
     * @param realName the value for bank_card.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }
}