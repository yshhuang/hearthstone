package com.huangyongsheng.hearthstone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.huangyongsheng.hearthstone.service.TokenService;

@RestController("CardController")
@RequestMapping(value = "/card")
public class CardController {
	private static Logger logger = LoggerFactory.getLogger(TokenController.class);
	@Autowired
	CardService cardService;

	@PostMapping()
	public ResultModel addCard(@RequestBody Card card) {
		logger.info("card/add");
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
		logger.info("card/get");
		List<Card> cards = cardService.getCards(pageNumber, pageSize);
		if (cards != null) {
			return ResultModel.ok(ResultStatus.OK, cards);
		} else {
			return ResultModel.error(ResultStatus.OK);
		}
	}

}