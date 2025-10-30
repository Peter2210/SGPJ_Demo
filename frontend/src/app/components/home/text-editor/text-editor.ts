// src/app/text-editor/text-editor.ts
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import  hljs  from 'highlight.js';
import { QuillModule } from 'ngx-quill';

import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'text-editor',
  standalone: true,
  imports: [CommonModule, FormsModule, QuillModule],
  templateUrl: './text-editor.html',
  styleUrl: './text-editor.css'
})
export class TextEditor {
  content = '';
  quillEditor: any;

  constructor(private sanitizer: DomSanitizer) {}
  get safeHtml(): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(this.content);
  }

  get wordCount(): number {
    return this.content ? this.content.trim().split(/\s+/).length : 0;
  }

  modules = {
    syntax: { hljs },
    toolbar: {
      container: [
        [{ header: [1, 2, 3, 4, 5, false] }],
        ['bold', 'italic', 'underline', 'strike'],
        [{ list: 'ordered' }, { list: 'bullet' }],
        [{ script: 'sub' }, { script: 'super' }],
        [{ indent: '-1' }, { indent: '+1' }],
        [{ direction: 'rtl' }],
        [{ align: [] }],
        [{ color: [] }, { background: [] }],
        ['link', 'image', 'video', 'formula'],
        ['blockquote', 'code-block'],
        ['clean'],
      ]
    }
  };

  onEditorCreated(quill: any) {
    this.quillEditor = quill;
  }
}
