package org.luojj.dao;

import org.luojj.entity.BankCard;

public interface BankCardDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String phoneNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    int insert(BankCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    int insertSelective(BankCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    BankCard selectByPrimaryKey(String phoneNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BankCard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank_card
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BankCard record);
}