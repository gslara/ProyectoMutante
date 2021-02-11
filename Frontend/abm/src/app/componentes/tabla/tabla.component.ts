import { Component, OnInit } from '@angular/core';
import { Mutante } from 'src/app/entidades/mutante';
import { PersonaService } from 'src/app/servicio/persona.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {

  personas: Mutante[] = [];

  constructor(private servicio: PersonaService, private router: Router) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.servicio.getAll().subscribe((data) => { //me subscribo para que sea asíncrono, el servicio es externo
      this.personas = data;                      //(data) => {} --> es una función flecha
      console.log(this.personas);
    });
  }

  delete(id: number) {
    const opcion = confirm('Está seguro que desea eliminar?');

    if(opcion === true){
      this.servicio.delete(id).subscribe((data) => {
        console.log(data);  //pongo lo que devuelve el controller
        alert('Registro eliminado');
        location.reload();  //recarga la página
      });
    }
  }
  
  update(id: number){
    this.router.navigate(['mutante2/' + id]);
  }

  agregar(id: number){
    this.router.navigate(['mutante2/' + id]);
  }
  
  goStats() {
      this.router.navigate(['stats']);
  }
  

}