package org.luojj.entity;

import java.util.Date;

public class bankCardNumberInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card_number_info.bank_card_number
     *
     * @mbggenerated
     */
    private String bankCardNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card_number_info.bank
     *
     * @mbggenerated
     */
    private String bank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_card_number_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card_number_info.bank_card_number
     *
     * @return the value of bank_card_number_info.bank_card_number
     *
     * @mbggenerated
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card_number_info.bank_card_number
     *
     * @param bankCardNumber the value for bank_card_number_info.bank_card_number
     *
     * @mbggenerated
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card_number_info.bank
     *
     * @return the value of bank_card_number_info.bank
     *
     * @mbggenerated
     */
    public String getBank() {
        return bank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card_number_info.bank
     *
     * @param bank the value for bank_card_number_info.bank
     *
     * @mbggenerated
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_card_number_info.create_time
     *
     * @return the value of bank_card_number_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_card_number_info.create_time
     *
     * @param createTime the value for bank_card_number_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}