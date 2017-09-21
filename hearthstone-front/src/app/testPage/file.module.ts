import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FileUploadModule } from 'ng2-file-upload';

import { FileComponent } from './file.component';

@NgModule({
    imports: [
        CommonModule,
        FileUploadModule
    ],
    providers: [],
    declarations: [
        FileComponent,
    ]
})

export class FileModule { }
