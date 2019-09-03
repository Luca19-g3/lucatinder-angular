import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoComponent } from './componentes/listado/listado.component';
import { ServicioService } from './servicio/servicio.service';
import { FooterComponent } from './componentes/footer/footer.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { SelectorComponent } from './componentes/selector/selector.component';
import { ContactosComponent } from './componentes/contactos/contactos.component';
import { DescartesComponent } from './componentes/descartes/descartes.component';
import { MatchesComponent } from './componentes/matches/matches.component';
import { ChatComponent } from './componentes/chat/chat.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoComponent,
    FooterComponent,
    MenuComponent,
    SelectorComponent,
    ContactosComponent,
    DescartesComponent,
    MatchesComponent,
    ChatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ServicioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
