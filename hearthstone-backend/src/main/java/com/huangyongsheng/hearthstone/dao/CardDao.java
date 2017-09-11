package com.huangyongsheng.hearthstone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huangyongsheng.hearthstone.annotation.MyBatisRepository;
import com.huangyongsheng.hearthstone.pojo.po.Card;

@MyBatisRepository
public interface CardDao {
	void addCard(Card card);

	List<Card> getCards(@Param(value = "start") Integer start, @Param(value = "size") Integer pageSize);

}
