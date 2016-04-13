package org.luojj.dao;

import org.luojj.entity.bankCardNumberInfo;

public interface BankCardNumberInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String bankCardNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    int insert(bankCardNumberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    int insertSelective(bankCardNumberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    bankCardNumberInfo selectByPrimaryKey(String bankCardNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(bankCardNumberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card_number_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(bankCardNumberInfo record);
}