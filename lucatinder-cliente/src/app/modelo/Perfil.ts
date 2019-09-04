export class Perfil {

    correo: string;
    password: string;
    nombre: string;
    edad: number;
    genero: string;
    preferencias: string;
    id?:number;


    constructor(correo: string,
        password: string,
        nombre: string,
        edad: number,
        genero: string,
        preferencias: string,
        id?:number
        ) {

        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.preferencias = preferencias;
        this.id = id;


    }

}