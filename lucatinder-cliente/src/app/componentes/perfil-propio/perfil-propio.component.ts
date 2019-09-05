import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Perfil } from 'src/app/modelo/perfil';
import { ServicioService } from 'src/app/servicio/servicio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil-propio',
  templateUrl: './perfil-propio.component.html',
  styleUrls: ['./perfil-propio.component.css']
})
export class PerfilPropioComponent implements OnInit {

  formulario: FormGroup;
  perfil: Perfil;

  constructor(private _servicio: ServicioService, private ruta: Router) { }

  ngOnInit() {
    this.formulario = new FormGroup({
      correo: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, Validators.required),
      nombre: new FormControl(null, Validators.required),
      edad: new FormControl(null, Validators.required),
      genero: new FormControl(null, Validators.required),
      preferencias: new FormControl(null, Validators.required),
      descripcion: new FormControl(null, Validators.required),
      img: new FormControl(null, Validators.required)
    });

    this._servicio.obtenerPerfil(parseInt(localStorage.getItem("id_lucatinder"))).subscribe((respuesta: Perfil) => {
      this.perfil = respuesta;
      if (this.perfil.correo) this.formulario.controls['correo'].setValue(this.perfil.correo);
      if (this.perfil.password) this.formulario.controls['password'].setValue(this.perfil.password);
      if (this.perfil.nombre) this.formulario.controls['nombre'].setValue(this.perfil.nombre);
      if (this.perfil.edad) this.formulario.controls['edad'].setValue(this.perfil.edad);
      if (this.perfil.genero) this.formulario.controls['genero'].setValue(this.perfil.genero);
      if (this.perfil.preferencias) this.formulario.controls['preferencias'].setValue(this.perfil.preferencias);
      if (this.perfil.descripcion) this.formulario.controls['descripcion'].setValue(this.perfil.descripcion);
      if (this.perfil.img) this.formulario.controls['img'].setValue(this.perfil.img);
    });

  }

  async cargarUsuario() {
    await this._servicio.obtenerPerfil(parseInt(localStorage.getItem("id_lucatinder"))).subscribe((respuesta: Perfil) => { this.perfil = respuesta; console.log(respuesta) });
  }

  guardarUsuario() {

    this.perfil = new Perfil(
      this.formulario.value.correo,
      this.formulario.value.password,
      this.formulario.value.nombre,
      this.formulario.value.edad,
      this.formulario.value.genero,
      this.formulario.value.preferencias);

    console.info(this.perfil);

    //this._servicio.crearPerfil(this.perfil).subscribe((respuesta:Perfil)=>{console.log(respuesta)});
  }

  borrarUsuario() {
    this._servicio.bajaPerfil(this.perfil.id).subscribe();
    localStorage.removeItem("id_lucatinder");
    this.ruta.navigate(["/"]);
  }

  salir(){
    localStorage.removeItem("id_lucatinder");
    this.ruta.navigate(["/"]);
  }

}
