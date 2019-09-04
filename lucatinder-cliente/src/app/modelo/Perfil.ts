export class Perfil {

    correo: string;
    password: string;
    nombre: string;
    edad: number;
    genero: string;
    preferencias: string;


    constructor(correo: string,
        password: string,
        nombre: string,
        edad: number,
        genero: string,
        preferencias: string) {

        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.preferencias = preferencias;


    }

}