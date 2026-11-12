import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DemoRest {
  private http = inject(HttpClient);
  private url = 'https://bookish-potato-4jwr5wwx69gphqpwj-8080.app.github.dev'; 
  getParametros(): Observable<any[]> {
    return this.http.get<any[]>(this. url+"/params");
  }

  getToken(): Observable<string> {
    return this.http.post(this. url+"/auth",{username:'admin',password:'admin'},{responseType: 'text' });
  }
}
