import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { CardModule } from './card/card.module';
import { AppRoutingModule } from './app-routing.module';
import { FileModule } from './testPage/file.module';

import { AppComponent } from './app.component';
import { FileComponent } from './testPage/file.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule,
    CardModule,
    FileModule,
  ],

  declarations: [
    AppComponent,
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
