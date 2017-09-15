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
    total = 0;
    pageNumber = 1;
    pageSize = 1;
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
            .getCards(this.pageNumber, this.pageSize)
            .then(result => {
                this.cards = result.cards;
                this.total = result.total;
            });
    }

    add(): void {
        console.log(this.card);
        this.cardService.create(this.card);
    }
}
