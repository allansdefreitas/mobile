import { Component, ViewChild } from '@angular/core';
import { Platform, Nav } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';


@Component({
  templateUrl: 'app.html'
})
export class MyApp {

  /* Selecionar um elemento do template home.html:
    pode ser pelo tipo (Nav) ou
    pelo elemento que possui uma determinada variável (#myNavVariable) */
  @ViewChild('myNavVariable') nav: Nav; /* ou @ViewChild(Nav)*/

  rootPage:any = 'home-page-lazy';

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();

      //this.nav.push('contact-page-lazy');
    });
  }
}

