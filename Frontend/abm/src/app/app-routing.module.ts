import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TablaComponent } from './componentes/tabla/tabla.component';
import { ElementoComponent } from './componentes/elemento/elemento.component';
import { EstadisticasComponent } from './componentes/estadisticas/estadisticas.component';


const routes: Routes = [

  {path: '', component: TablaComponent},
  {path: 'mutante2/:id', component: ElementoComponent},
  {path: 'stats', component: EstadisticasComponent},
  {path: '*', pathMatch: 'full', redirectTo: ''}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
