package com.huangyongsheng.hearthstone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyongsheng.hearthstone.dao.CardDao;
import com.huangyongsheng.hearthstone.pojo.po.Card;
import com.huangyongsheng.hearthstone.service.CardService;

@Service("CardServiceImpl")
public class CardServiceImpl implements CardService {
	@Autowired
	CardDao cardDao;

	@Override
	public Long addCard(Card card) {
		cardDao.addCard(card);
		return card.getCardId();
	}

	@Override
	public List<Card> getCards(Integer pageNumber, Integer pageSize) {
		Integer start = (pageNumber - 1) * pageSize;
		return cardDao.getCards(start, pageSize);
	}

	@Override
	public Integer getTotalCard() {
		return cardDao.getTotalCard();
	}

}
