import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-descartes',
  templateUrl: './descartes.component.html',
  styleUrls: ['./descartes.component.css']
})
export class DescartesComponent implements OnInit {

  descartes:Perfil[]=[];
  id: number;

  constructor(public _servicio:ServicioService) { }

  ngOnInit() {
    this.id = parseInt(window.localStorage.getItem("id_lucatinder"));
    this.obtenerDescartes(this.id);
  }

 obtenerDescartes(id:number){
    this._servicio.obtenerDescartes(id).subscribe((datos:Perfil[])=>{this.descartes = datos});
  }

}
