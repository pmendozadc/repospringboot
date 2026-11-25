import { ChangeDetectorRef, Component} from '@angular/core';
import { Router } from '@angular/router';
import { inject, Injectable } from '@angular/core';
import { ServiceAdministrarProductos } from '../services/service-administrar-productos';

@Component({
  selector: 'app-view-productos',
  imports: [],
  templateUrl: './view-productos.html',
  styleUrl: './view-productos.css',
})
export class ViewProductos {

  private router = inject(Router);

  productos!: any[];

  private serviceAdministrarProductos = inject(ServiceAdministrarProductos);

  constructor(private cdr:ChangeDetectorRef){}

  ngOnInit(): void {
    this.serviceAdministrarProductos.getProductos().subscribe({
    next: (data) => {
      console.log('Datos recibidos del servicio:', data);
      this.productos=data;
      this.cdr.markForCheck();
    },
    error: (err) => console.error('Error al llamar al servicio:', err),
    });
  }

irAProductoNuevo() {
  this.router.navigate(['/producto/nuevo']);
}

}
