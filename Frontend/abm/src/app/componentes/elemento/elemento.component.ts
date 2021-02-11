import { Component, OnInit } from '@angular/core';
import { Mutante } from 'src/app/entidades/mutante';
import { PersonaService } from 'src/app/servicio/persona.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-elemento',
  templateUrl: './elemento.component.html',
  styleUrls: ['./elemento.component.css']
})
export class ElementoComponent implements OnInit {

  persona: Mutante = {
    id: null,
    nombre: null,
    apellido: null,
    dna: [null, null, null, null, null, null],
    mutacion: null
  }


  constructor(private servicio: PersonaService, private rutaActiva: ActivatedRoute, private router: Router) { }

  
  ngOnInit() {
    this.rutaActiva.params.subscribe(data => {
      if (data['id'] != '0') {
        this.getOne(data['id']);
      }
    });
    
  }


  getOne(id: number){
    this.servicio.getOne(id).subscribe(data => {
      this.persona = data;
    });
  }


  save(){
    this.rutaActiva.params.subscribe(data => {
      this.validar();
      if (data['id'] === '0') {
        this.add();
      } else {
        this.update(data['id']);
      }
      
    });
  }


  add(){
    this.servicio.post(this.persona).subscribe(data => {
      this.persona = data;
      this.router.navigate(['']); //Llamo a la ruta de app-routing.module.ts

    });
  }


  update(id: number){
    this.servicio.put(id, this.persona).subscribe(data => {
      this.persona = data;
      this.router.navigate(['']);
 
    });
  }


  cancelar() {
    this.router.navigate(['']);
  }


  validar() {
    var nombre, apellido, cadena1, cadena2, cadena3, cadena4, cadena5, cadena6, expresion;

    nombre = (<HTMLInputElement>document.getElementById("nombre")).value.toLowerCase();
    apellido = (<HTMLInputElement>document.getElementById("apellido")).value.toLowerCase();
    cadena1 = (<HTMLInputElement>document.getElementById("cadena1")).value.toUpperCase();
    cadena2 = (<HTMLInputElement>document.getElementById("cadena2")).value.toUpperCase();
    cadena3 = (<HTMLInputElement>document.getElementById("cadena3")).value.toUpperCase();
    cadena4 = (<HTMLInputElement>document.getElementById("cadena4")).value.toUpperCase();
    cadena5 = (<HTMLInputElement>document.getElementById("cadena5")).value.toUpperCase();
    cadena6 = (<HTMLInputElement>document.getElementById("cadena6")).value.toUpperCase();

    var letras = "abcdefghijklmnñopqrstuvwxyz";
    var adnvalido = "ACGT";
    
    if(nombre === "" || apellido === "" || cadena1 === "" || cadena2 === "" || cadena3 === "" || cadena4 === "" || cadena5 === "" || cadena6 === "") {
        alert("Todos los campos son obligatorios");
        return false;
    
    } else if (nombre.length > 30) {
        alert("El nombre no puede tener más de 30 caracteres");
        return false;

    } else if (apellido.length > 30) {
        alert("El apellido no puede tener más de 30 caracteres");
        return false;
    
    } else if (cadena1.length != 6 || cadena2.length != 6 || cadena3.length != 6 || cadena4.length != 6 || cadena5.length != 6 || cadena6.length != 6) {
        alert("Las cadenas de ADN deben tener 6 caracteres");
        return false;
    }

    for (var i = 0; i < nombre.length; i++) {
        if (!(letras.indexOf(nombre.charAt(i),0) != -1)) {
            alert("El nombre solo puede contener letras");
            return false;
        }
    }

    for (var i = 0; i < apellido.length; i++) {
        if (!(letras.indexOf(apellido.charAt(i),0) != -1)) {
            alert("El apellido solo puede contener letras");
            return false;
        }
    }

    for (var i = 0; i < cadena1.length; i++) {
      if (!(adnvalido.indexOf(cadena1.charAt(i),0) != -1)) {
          alert("La cadena 1 de ADN es inválida");
          return false;
      
      } else if (!(adnvalido.indexOf(cadena2.charAt(i),0) != -1)) {
        alert("La cadena 2 de ADN es inválida");
        return false;
    
      } else if (!(adnvalido.indexOf(cadena3.charAt(i),0) != -1)) {
        alert("La cadena 3 de ADN es inválida");
        return false;
  
      } else if (!(adnvalido.indexOf(cadena4.charAt(i),0) != -1)) {
        alert("La cadena 4 de ADN es inválida");
        return false;

      } else if (!(adnvalido.indexOf(cadena5.charAt(i),0) != -1)) {
        alert("La cadena 5 de ADN es inválida");
        return false;

      } else if (!(adnvalido.indexOf(cadena6.charAt(i),0) != -1)) {
        alert("La cadena 6 de ADN es inválida");
        return false;
      }
    }
  }

}
