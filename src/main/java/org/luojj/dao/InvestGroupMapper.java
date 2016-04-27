package org.luojj.dao;

import org.luojj.entity.InvestGroup;

public interface InvestGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
	InvestGroup getLatestInvestGroup(String phoneNumber);
    int deleteByPrimaryKey(Long investGroupId);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
    int insert(InvestGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
    int insertSelective(InvestGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
    InvestGroup selectByPrimaryKey(Long investGroupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(InvestGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invest_group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(InvestGroup record);
}