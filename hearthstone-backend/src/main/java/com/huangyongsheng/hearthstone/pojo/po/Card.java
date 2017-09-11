package com.huangyongsheng.hearthstone.pojo.po;

/*`card_id` INT UNSIGNED NOT NULL AUTO_INCREMENT                                            COMMENT '卡牌id',
`name` VARCHAR(16) NOT NULL                                                               COMMENT '名称',
`expense` TINYINT(2) NOT NULL                                                             COMMENT '消耗水晶',
`attack` TINYINT(2) NOT NULL                                                              COMMENT '攻击力',
`health_point` TINYINT(2) NOT NULL                                                        COMMENT '生命值',
`img_path`  VARCHAR(64) NOT NULL                                                          COMMENT '图片路径',*/
public class Card {
	private Long cardId;
	private String name;
	private Integer expense;
	private Integer attack;
	private Integer healthPoint;
	private String imgPath;

	public Card(Long cardId, String name, Integer expense, Integer attack, Integer healthPoint, String imgPath) {
		super();
		this.cardId = cardId;
		this.name = name;
		this.expense = expense;
		this.attack = attack;
		this.healthPoint = healthPoint;
		this.imgPath = imgPath;
	}

	public Card() {
		super();
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExpense() {
		return expense;
	}

	public void setExpense(Integer expense) {
		this.expense = expense;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(Integer healthPoint) {
		this.healthPoint = healthPoint;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", name=" + name + ", expense=" + expense + ", attack=" + attack
				+ ", healthPoint=" + healthPoint + ", imgPath=" + imgPath + "]";
	}

}
