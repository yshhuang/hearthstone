import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CardListComponent } from './card/cardList.component';
import { CardAddComponent } from './card/card-add.component';
import { FileComponent } from './testPage/file.component';

const routes: Routes = [
    { path: '', redirectTo: '/cardList', pathMatch: 'full' },
    { path: 'cardList', component: CardListComponent },
    { path: 'addCard', component: CardAddComponent },
    { path: 'test', component: FileComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
