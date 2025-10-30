import katex from 'katex';
(window as any).katex = katex;

import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

bootstrapApplication(App,appConfig)
  .catch((err) => console.error(err));
