package org.luojj.dao;

import org.luojj.entity.Asset;

public interface AssetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String phoneNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    int insert(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    int insertSelective(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    Asset selectByPrimaryKey(String phoneNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Asset record);
}