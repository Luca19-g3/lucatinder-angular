import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';

@Component({
  selector: 'app-selector',
  templateUrl: './selector.component.html',
  styleUrls: ['./selector.component.css']
})
export class SelectorComponent implements OnInit {
  private perfil: Perfil;
  constructor(private _service: ServicioService) { }
  ngOnInit() {
    this._service.obtenerPerfilAleatorio(1).subscribe(respuesta => {
      console.log(respuesta);
      this.perfil = respuesta;
    })
  }
}
