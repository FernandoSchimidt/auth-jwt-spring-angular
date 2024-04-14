import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideToastr } from 'ngx-toastr';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { customInterceptor } from './services/custom.interceptor';


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideToastr(),
    provideAnimations(),
    provideHttpClient(withFetch()),
    provideAnimationsAsync(), provideAnimationsAsync(),
    provideHttpClient(withInterceptors([customInterceptor])),
  ],
};
