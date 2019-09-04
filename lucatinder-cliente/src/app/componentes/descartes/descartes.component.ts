import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-descartes',
  templateUrl: './descartes.component.html',
  styleUrls: ['./descartes.component.css']
})
export class DescartesComponent implements OnInit {

  descartes:Perfil[];
  id: number = 1;

  constructor(public _servicio:ServicioService) { }

  ngOnInit() {
    this.obtenerPerfiles(this.id);
  }

  obtenerPerfiles(id:number){
    this._servicio.listaPerfiles(id).subscribe((datos:Perfil[])=>{this.descartes = datos});
  }

}
