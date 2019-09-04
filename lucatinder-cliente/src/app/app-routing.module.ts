import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoComponent } from './componentes/listado/listado.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { ContactosComponent } from './componentes/contactos/contactos.component';
import { DescartesComponent } from './componentes/descartes/descartes.component';
import { MatchesComponent } from './componentes/matches/matches.component';
import { ChatComponent } from './componentes/chat/chat.component';
import { PerfilComponent } from './componentes/perfil/perfil.component';
import { SelectorComponent } from './componentes/selector/selector.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'inicio',
    pathMatch: 'full'
  },
  {
    path: 'inicio',
    component: InicioComponent
  },
  {
    path: 'listado',
    component: ListadoComponent
  }
  ,
  {
    path: 'contactos',
    component: ContactosComponent
  }
  ,
  {
    path: 'descartes',
    component: DescartesComponent
  }
  ,
  {
    path: 'selector',
    component: SelectorComponent
  },
  {
    path: 'matches',
    component: MatchesComponent
  },
  {
    path: 'chat',
    component: ChatComponent
  },
  {
    path: 'perfil',
    component: ListadoComponent
  },
  {
    path: 'perfil/:id',
    component: PerfilComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
