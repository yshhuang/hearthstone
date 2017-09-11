import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { CardModule } from './card/card.module';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { CardListComponent } from './card/cardList.component';
import { CardAddComponent} from './card/card-add.component';
import { CardService } from './card/card.service';

@NgModule({
  declarations: [
    AppComponent,
    CardListComponent,
    CardAddComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    CardModule,
    AppRoutingModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
