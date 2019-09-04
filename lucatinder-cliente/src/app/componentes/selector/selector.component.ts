import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';
import { Router } from '@angular/router';
import { componentRefresh } from '@angular/core/src/render3/instructions';

@Component({
  selector: 'app-selector',
  templateUrl: './selector.component.html',
  styleUrls: ['./selector.component.css']
})
export class SelectorComponent implements OnInit {

  contacto: Perfil = null;
  id: number;

  constructor(private _service: ServicioService, private router: Router) {

  }


  ngOnInit() {
    this.id = parseInt(window.localStorage.getItem("id_lucatinder"));

    this._service.obtenerPerfilAleatorio(this.id).subscribe(respuesta => {
      console.error("-.-", respuesta);
      this.contacto = respuesta;
    });
  }

  calificar(like: boolean) {
    console.log("entrando en calificar");
    if (like) {


      console.log("IT'S A LIKE!!!!");
      this._service.darlike(this.id, this.contacto.id).subscribe(respuesta => {
        console.error("-.-", respuesta);

      });
    } else {
      console.log("IT'S A DISLIKE :(((((");
      this._service.dardislike(this.id, this.contacto.id).subscribe(respuesta => {
        console.error("-.-", respuesta);

      });

    }
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate(["/selector"]));

  }

  refresh(): void {
    window.location.reload();
  }
}






