import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app/app.component';
import { routes } from './app/app.routes';
import { provideRouter } from '@angular/router';

platformBrowserDynamic()
  .bootstrapModule(AppComponent, {
    providers: [provideRouter(routes)] as any,
  })
  .catch((err: any) => console.error(err));
