import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ActivatedRoute } from '@angular/router';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  usuario: Perfil = null;
  id:number;
 

  constructor(private route: ActivatedRoute, private _servicio:ServicioService) { }

  ngOnInit() {
    this.id = parseInt(this.route.snapshot.paramMap.get("id"));
    this._servicio.obtenerPerfil(this.id).subscribe((respuesta:Perfil)=>{this.usuario = respuesta});
  }

}
