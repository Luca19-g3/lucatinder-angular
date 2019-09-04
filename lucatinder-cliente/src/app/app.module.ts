import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';


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
import { AltaPerfilComponent } from './componentes/alta-perfil/alta-perfil.component';

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
    ChatComponent,
    AltaPerfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ServicioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
