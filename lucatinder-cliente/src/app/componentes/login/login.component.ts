import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ServicioService } from 'src/app/servicio/servicio.service';
import { Router } from '@angular/router';
import { Perfil } from 'src/app/modelo/perfil';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;

  constructor(public _servicio:ServicioService, private router: Router) { }

  ngOnInit() {
    this.formulario = new FormGroup( {
      id: new FormControl( null, Validators.required )
    });
  }

  loginUsuario(){
      console.info(this.formulario.value.id);
     this._servicio.login(this.formulario.value.id).subscribe((respuesta:Perfil)=>{
       console.log(respuesta);
       if(respuesta != null){
        this.router.navigate(['/listado']);
        window.localStorage.setItem('id_lucatinder', (respuesta.id).toString() );
       }
      });
   }

}
