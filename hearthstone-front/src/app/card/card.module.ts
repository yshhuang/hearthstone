import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { CardListComponent } from './cardList.component';
import { CardAddComponent } from './card-add.component';
import { CardService } from './card.service';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
    ],
    providers: [CardService],
    declarations: [
        CardListComponent,
        CardAddComponent]
})

export class CardModule { }
