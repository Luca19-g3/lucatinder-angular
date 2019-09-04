import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Perfil } from '../modelo/perfil';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private userUrl = 'http://localhost:8080/';

  constructor(public http: HttpClient) { }

  obtenerPerfiles(id: number) {
    return this.http.get(this.userUrl + "perfilesrest?id=" + id);
  }

  obtenerContactos(id: number) {
    return this.http.get(this.userUrl + "contactosrest?id=" + id);
  }

  crearPerfil(perfil: Perfil) {
    return this.http.post(this.userUrl + "newrest", perfil);
  }

  login(id:number){
    console.log(this.userUrl + "entrarrest?id=" + id);
    return this.http.get(this.userUrl + "entrarrest?id=" + id);
  }

  obtenerPerfilAleatorio(id: number){
    return this.http.get<Perfil>(this.userUrl + "getperfilrandomrest?id=" + id);
  }
  
}
