package org.luojj.dao;

import org.luojj.entity.Fund;

public interface FundMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    int insert(Fund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    int insertSelective(Fund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    Fund selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Fund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Fund record);
}