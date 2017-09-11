import { Component, OnInit } from '@angular/core';

import { Card } from './card';
import { CardService } from './card.service';

@Component({
    selector: 'card-list',
    templateUrl: './cardList.component.html',
    // styleUrls: ['./app.component.css']
})

export class CardListComponent implements OnInit {
    title = 'hearthstone';
    cards: Card[];
    card: Card = new Card;

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
        console.log(this.card);
        this.cardService.create(this.card);
    }
}
