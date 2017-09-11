import { Component } from '@angular/core';

import { Card } from './card';
import { CardService } from './card.service';

@Component({
    selector: 'card-list',
    templateUrl: './card-add.component.html',
    // styleUrls: ['./app.component.css']
})

export class CardAddComponent {
    title = 'hearthstone';
    card: Card = new Card;

    constructor(
        private cardService: CardService
    ) { }

    add(): void {
        console.log(this.card);
        this.cardService.create(this.card);
    }
}
