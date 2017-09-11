import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Card } from './card';

@Injectable()
export class CardService {
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private cardUrl = 'http://localhost:8080/ssm/card';  // URL to web api

    constructor(private http: Http) { }

    create(card: Card): Promise<Card> {
        return this.http
            .post(this.cardUrl, card, { headers: this.headers })
            .toPromise()
            .then(res => res.json().data as Card);
    }

    getCards(pageNumber: number, pageSize: number): Promise<Card[]> {
        return this.http.get(this.cardUrl + '?pageNumber=' + pageNumber + '&pageSize=' + pageSize)
            .toPromise()
            .then(response => response.json().data as Card[]);
    }
}
