import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mutante } from '../entidades/mutante';
import { Stats } from '../entidades/stats';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  miUrl: string = 'http://localhost:9001/api/v1/mutante2/';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Mutante[]>{
    return this.http.get<Mutante[]>(this.miUrl);    
  }

  getOne(id: number): Observable<Mutante>{
    return this.http.get<Mutante>(this.miUrl + id);
  }

  delete(id: number): Observable<any>{
    console.log(id);
    return this.http.delete(this.miUrl + id);
  }

  post(persona: Mutante): Observable<Mutante>{
    return this.http.post<Mutante>(this.miUrl, persona);
  }
  
  put(id: number, persona: Mutante): Observable<Mutante>{
    return this.http.put<Mutante>(this.miUrl + id, persona);
  }

  getStats(): Observable<Stats>{
    return this.http.get<Stats>(this.miUrl + 'stats');
  }
}
