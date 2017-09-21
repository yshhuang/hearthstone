import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { Http } from '@angular/http';
import { FileUploader, FileSelectDirective } from 'ng2-file-upload';

@Component({
    selector: 'file-upload',
    templateUrl: './file.component.html',
})

export class FileComponent {
    title = 'app works!';

    public url = 'http://localhost:8080/hearthstone/file/';
    public uploader: FileUploader = new FileUploader({ url: this.url });
}
