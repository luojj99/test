package org.luojj.dao;

import java.util.List;

import org.luojj.entity.MessageCenter;

public interface MessageCenterMapper {
	
	List<MessageCenter> getMsgList();
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long msgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    int insert(MessageCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    int insertSelective(MessageCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    MessageCenter selectByPrimaryKey(Long msgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MessageCenter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MessageCenter record);
}