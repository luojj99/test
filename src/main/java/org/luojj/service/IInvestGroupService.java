package org.luojj.service;

import java.math.BigDecimal;
import java.util.List;

import org.luojj.entity.InvestGroup;



public interface IInvestGroupService {
	public InvestGroup getInvestGroup(Long investGroupId);
	public List<InvestGroup> getInvestGroupList(String phoneNumber);
	public BigDecimal getGroupProfit(InvestGroup investGroup);
}
