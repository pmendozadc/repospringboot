import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { ModalProducto } from '../modal-producto/modal-producto'

@Component({
  selector: 'app-view-productos',
  imports: [ModalProducto],
  templateUrl: './view-productos.html',
  styleUrl: './view-productos.css',
})
export class ViewProductos {

  private router = inject(Router);

  productos: any[] = [
    { id: 1, nombre: 'Laptop Pro', precio: 1200, disponible: true },
    { id: 2, nombre: 'Teclado Mecánico', precio: 85, disponible: true },
    { id: 3, nombre: 'Monitor 4K', precio: 350, disponible: false },
    { id: 4, nombre: 'Ratón Ergonómico', precio: 45, disponible: true }
  ];

  mostrarModal = false;

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
  this.router.navigate(['/producto', 15]);
}
}
