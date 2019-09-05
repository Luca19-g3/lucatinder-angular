import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/Perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  matches: Perfil[] = [];
  id: number;
  constructor(public _servicio: ServicioService) { }

  ngOnInit() {
    this.id = parseInt(window.localStorage.getItem('id_lucatinder'));
    this.obtenerMatches(this.id);
  }
  obtenerMatches(id: number) {
    this._servicio.listaMatches(id).subscribe((datos: Perfil[]) => { this.matches = datos });
  }
}
