package com.huangyongsheng.hearthstone.service;

import java.util.List;

import com.huangyongsheng.hearthstone.pojo.po.Card;

public interface CardService {
	Long addCard(Card card);

	List<Card> getCards(Integer pageNumber, Integer pageSize);

	Integer getTotalCard();
}
