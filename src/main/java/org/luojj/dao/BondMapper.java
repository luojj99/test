package org.luojj.dao;

import org.luojj.entity.Bond;

public interface BondMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    int insert(Bond record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    int insertSelective(Bond record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    Bond selectByPrimaryKey(Long productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Bond record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bond_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Bond record);
}