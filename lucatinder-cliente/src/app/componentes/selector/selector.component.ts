import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-selector',
  templateUrl: './selector.component.html',
  styleUrls: ['./selector.component.css']
})
export class SelectorComponent implements OnInit {

  private perfil: Perfil=null;
  private id: number;

  constructor(private _service: ServicioService, private router:Router) {
   
  }
  

  ngOnInit() {  
    this.id = parseInt(window.localStorage.getItem("id_lucatinder"));

    this._service.obtenerPerfilAleatorio(this.id).subscribe(respuesta => {
      console.error("-.-",respuesta);
      this.perfil = respuesta;
   });
  }

  calificar(like: boolean) {
    console.log("entrando en calificar");
    if (like) {


      console.log("IT'S A LIKE!!!!");
      this._service.darlike(this.id, this.perfil.id).subscribe(respuesta => {
        console.error("-.-",respuesta);
        
      });
    } else {
      console.log("IT'S A DISLIKE :(((((");
      this._service.dardislike(this.id,this.perfil.id).subscribe(respuesta => {
        console.error("-.-",respuesta);
        
      });
      
    }
  
      this.refresh();
  
  }

  refresh() : void {
    window.location.reload();
  }
}






