import { Component, OnInit } from '@angular/core';

import { Card } from './card';
import { CardService } from './card.service';

@Component({
    selector: 'card-list',
    templateUrl: './cardList.component.html',
    styleUrls: ['./card-list.component.css']
})

export class CardListComponent implements OnInit {
    title = 'hearthstone';
    total = 0;
    pageNumber = 1;
    pageSize = 5;
    cards: Card[];
    selectCard: Card = new Card;

    constructor(
        private cardService: CardService
    ) { }

    ngOnInit(): void {
        this.getCards();
    }

    getCards(): void {
        this.cardService
            .getCards(this.pageNumber, this.pageSize)
            .then(result => {
                this.cards = result.cards;
                this.selectCard = this.cards[0];
                this.total = result.total;
            });
    }

    select(card: Card): void {
        this.selectCard = card;
    }
}
