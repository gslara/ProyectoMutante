import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TablaComponent } from './componentes/tabla/tabla.component';
import { ElementoComponent } from './componentes/elemento/elemento.component';
import { PersonaService } from './servicio/persona.service';
import { EstadisticasComponent } from './componentes/estadisticas/estadisticas.component';

@NgModule({
  declarations: [
    AppComponent,
    TablaComponent,
    ElementoComponent,
    EstadisticasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PersonaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
