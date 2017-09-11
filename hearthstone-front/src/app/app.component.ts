import { Component, OnInit } from '@angular/core';
import { CardService } from './card.service';
import { Card } from './card/card';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = '炉石卡牌库';
  cards: Card[];
  card1: Card;

  constructor(
    private cardService: CardService
  ) { }

  ngOnInit(): void {
    this.getCards();
  }

  getCards(): void {
    this.cardService
      .getCards(1, 100)
      .then(cards => this.cards = cards);
  }

  add(): void {
    console.log(this.card1);
    // this.cardService.create(this.card);
  }
}
