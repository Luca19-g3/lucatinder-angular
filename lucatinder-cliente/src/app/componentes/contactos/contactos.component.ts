import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/Perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-contactos',
  templateUrl: './contactos.component.html',
  styleUrls: ['./contactos.component.css']
})
export class ContactosComponent implements OnInit {

  contactos: Perfil[]=[];

  constructor(public _servicio: ServicioService) { }

  ngOnInit() {
    //this.obtenerContactos(1);
  }

  obtenerContactos(id: number) {
    this._servicio.obtenerContactos(id).subscribe((datos: Perfil[]) => { this.contactos = datos });
  }

}
