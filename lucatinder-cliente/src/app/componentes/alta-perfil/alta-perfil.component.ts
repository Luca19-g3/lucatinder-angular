import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alta-perfil',
  templateUrl: './alta-perfil.component.html',
  styleUrls: ['./alta-perfil.component.css']
})
export class AltaPerfilComponent implements OnInit {

  perfil: Perfil;
  formulario: FormGroup;

  constructor(public _servicio: ServicioService, private ruta: Router) { }

  ngOnInit() {
    this.formulario = new FormGroup({
      correo: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, Validators.required),
      nombre: new FormControl(null, Validators.required),
      edad: new FormControl(null, Validators.required),
      genero: new FormControl(null, Validators.required),
      preferencias: new FormControl(null, Validators.required)
    });
  }

  registrarUsuario() {
    this.perfil = new Perfil(
      this.formulario.value.correo,
      this.formulario.value.password,
      this.formulario.value.nombre,
      this.formulario.value.edad,
      this.formulario.value.genero,
      this.formulario.value.preferencias);

    this._servicio.crearPerfil(this.perfil).subscribe((respuesta: Perfil) => {
      console.log(respuesta);
    });
  }

}
