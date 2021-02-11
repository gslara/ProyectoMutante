import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/servicio/persona.service';
import { Router } from '@angular/router';
import { Stats } from 'src/app/entidades/stats';

@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.css']
})
export class EstadisticasComponent implements OnInit {

  estadisticas: Stats;

  constructor(private servicio: PersonaService, private router: Router) { }

  ngOnInit() {
    this.getStats();
  }
  
  getStats() {
    this.servicio.getStats().subscribe((data2) => { 
      this.estadisticas = data2;      
      console.log("acá deberían ir los datos");  
      console.log(data2);              
      console.log(this.estadisticas);
    });
  }
  
  volver() {
    this.router.navigate(['']);
  }
}
