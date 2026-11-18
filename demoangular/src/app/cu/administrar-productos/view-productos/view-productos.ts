import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { ModalProducto } from '../modal-producto/modal-producto'
import { inject, Injectable } from '@angular/core';
import { ServiceAdministrarProductos } from '../service-administrar-productos';

@Component({
  selector: 'app-view-productos',
  imports: [ModalProducto],
  templateUrl: './view-productos.html',
  styleUrl: './view-productos.css',
})
export class ViewProductos {

  private router = inject(Router);

  productos!: any[];

  mostrarModal = false;

  private serviceAdministrarProductos = inject(ServiceAdministrarProductos);

  ngOnInit(): void {
    this.serviceAdministrarProductos.getProductos().subscribe({
    next: (data) => console.log('Datos recibidos del servicio:', data),
    error: (err) => console.error('Error al llamar al servicio:', err),
    });
  }
productoSeleccionado: any = null;

editarProducto(producto: any) {
  this.productoSeleccionado = { ...producto };
  this.mostrarModal = true;
}

cerrarModal() {
  this.mostrarModal = false;
  this.productoSeleccionado = null;
}

irAProductoNuevo() {
  this.router.navigate(['/producto/nuevo']);
}

irAProductoEdicion(id:Number) {
  this.router.navigate(['/producto',id]);
}

irAProductoEdicionConObjeto(producto:any) {
  this.router.navigate(['/producto',producto.id], {
    state: {
      producto: producto
    }
  });
}
}
