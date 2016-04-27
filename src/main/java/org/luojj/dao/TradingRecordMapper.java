package org.luojj.dao;

import java.util.List;

import org.luojj.entity.TradingRecord;

public interface TradingRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
	List<TradingRecord> getRecordListByPhoneNo(String phoneNumber);
	
    int deleteByPrimaryKey(Long tradingRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
    int insert(TradingRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
    int insertSelective(TradingRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
    TradingRecord selectByPrimaryKey(Long tradingRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TradingRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trading_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TradingRecord record);
}