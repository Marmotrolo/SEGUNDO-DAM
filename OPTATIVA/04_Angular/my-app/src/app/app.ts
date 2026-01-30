import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: ` Hello {{musico}} `,
  styles: `
    :host {
      color: #2cd7f5;
    }
  `,
})
export class App {
musico= 'Manuel Parrado'

}
