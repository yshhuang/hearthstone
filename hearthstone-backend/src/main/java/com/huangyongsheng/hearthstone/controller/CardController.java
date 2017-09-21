package com.huangyongsheng.hearthstone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huangyongsheng.hearthstone.pojo.dto.ResultModel;
import com.huangyongsheng.hearthstone.pojo.dto.ResultStatus;
import com.huangyongsheng.hearthstone.pojo.po.Card;
import com.huangyongsheng.hearthstone.service.CardService;

import lombok.extern.log4j.Log4j;

@RestController("CardController")
@RequestMapping(value = "/card")
public @Log4j class CardController {
	@Autowired
	CardService cardService;

	@PostMapping()
	public ResultModel addCard(@RequestBody Card card) {
		log.info("card/add");
		System.out.println(card.toString());
		Long cardId = cardService.addCard(card);
		if (cardId != null) {
			return ResultModel.ok(ResultStatus.OK, cardId);
		} else {
			return ResultModel.error(ResultStatus.OK);
		}
	}

	@GetMapping()
	public ResultModel getCards(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		log.info("card/get");
		List<Card> cards = cardService.getCards(pageNumber, pageSize);
		Integer total = cardService.getTotalCard();
		if (cards != null) {
			Map<String, Object> result = new HashMap<>();
			result.put("cards", cards);
			result.put("total", total);
			return ResultModel.ok(ResultStatus.OK, result);
		} else {
			return ResultModel.error(ResultStatus.OK);
		}
	}

}
