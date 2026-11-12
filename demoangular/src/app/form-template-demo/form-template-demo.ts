import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { DemoRest } from '../servicios/demo-rest';
import { inject, Injectable } from '@angular/core';

@Component({
  selector: 'app-form-template-demo',
  imports: [FormsModule],
  templateUrl: './form-template-demo.html',
  styleUrl: './form-template-demo.css',
})
export class FormTemplateDemo {

  private demoService = inject(DemoRest);

  onEnviar(form: NgForm) {
    console.log('Data del formulario:', form.value);
    /*
    this.demoService.getParametros().subscribe({
      next: (data) => console.log('Datos recibidos del servicio:', data),
      error: (err) => console.error('Error al llamar al servicio:', err),
    });
    */
    this.demoService.getToken().subscribe({
      next: (data) => console.log('Token:', data),
      error: (err) => console.error('Error al llamar al servicio:', err),
    });
  }

}

