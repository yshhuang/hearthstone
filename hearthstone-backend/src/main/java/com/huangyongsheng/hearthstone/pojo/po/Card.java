package com.huangyongsheng.hearthstone.pojo.po;

import lombok.Data;

/*`card_id` INT UNSIGNED NOT NULL AUTO_INCREMENT                                            COMMENT '卡牌id',
`name` VARCHAR(16) NOT NULL                                                               COMMENT '名称',
`expense` TINYINT(2) NOT NULL                                                             COMMENT '消耗水晶',
`attack` TINYINT(2) NOT NULL                                                              COMMENT '攻击力',
`health_point` TINYINT(2) NOT NULL                                                        COMMENT '生命值',
`img_path`  VARCHAR(64) NOT NULL                                                          COMMENT '图片路径',*/
@Data
public class Card {
	private Long cardId;
	private String name;
	private Integer expense;
	private Integer attack;
	private Integer healthPoint;
	private String imgPath;

}
