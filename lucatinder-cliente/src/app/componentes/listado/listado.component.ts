import { Component, OnInit } from '@angular/core';
import { ServicioService } from '../../servicio/servicio.service';
import { Perfil } from '../../modelo/Perfil';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  perfiles:Perfil[];
  id: number;

  constructor(public _servicio:ServicioService) { }

  ngOnInit() {
    this.id = parseInt(window.localStorage.getItem('id_lucatinder'));
    this.obtenerPerfiles(this.id);
  }

  obtenerPerfiles(id:number){
    this._servicio.listaPerfiles(id).subscribe((datos:Perfil[])=>{this.perfiles = datos});
  }

}
