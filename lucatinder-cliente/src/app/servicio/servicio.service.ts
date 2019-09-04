import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Perfil } from '../modelo/perfil';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private userUrl = 'http://localhost:8080/';

  constructor(public http: HttpClient) { }

  listaPerfiles(id: number) {
    return this.http.get(this.userUrl + "perfilesrest?id=" + id);
  }

  obtenerContactos(id: number) {
    return this.http.get(this.userUrl + "contactosrest?id=" + id);
  }

  obtenerDescartes(id: number) {
    return this.http.get(this.userUrl + "descartesrest?id=" + id);
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

  dardislike(id1: number,id2: number){
   return this.http.get(this.userUrl + "dardislikerest?id1=" + id1 + "&id2="+id2);
  }
  darlike(id1: number,id2: number){
   return this.http.get(this.userUrl + "darlikerest?id1=" + id1 + "&id2="+id2);
  }

}
