import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Perfil } from '../modelo/perfil';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private userUrl = 'http://localhost:8080/';

  constructor(public http: HttpClient) { }

  crearUsuario(perfil: Perfil) {
    this.http.post(this.userUrl + "newrest", perfil);
  }

  obtenerPerfiles(id:number){
    return this.http.get(this.userUrl + "perfilesrest?id="+id);
  }

  obtenerContactos(id:number){
    return this.http.get(this.userUrl + "contactosrest?id="+id);
  }
  
}
