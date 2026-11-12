import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

interface Producto {
  id: number;
  nombre: string;
  precio: number;
  disponible: boolean;
}

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('demoangular');
  productos: Producto[] = [
    { id: 1, nombre: 'Laptop Pro', precio: 1200, disponible: true },
    { id: 2, nombre: 'Teclado Mecánico', precio: 85, disponible: true },
    { id: 3, nombre: 'Monitor 4K', precio: 350, disponible: false },
    { id: 4, nombre: 'Ratón Ergonómico', precio: 45, disponible: true }
  ];

  // Control del menú responsive
  menuAbierto = false;

  // Control de la ventana modal
  modalAbierto = false;

  toggleMenu(): void {
    this.menuAbierto = !this.menuAbierto;
  }

  abrirModal(): void {
    this.modalAbierto = true;
  }

  cerrarModal(): void {
    this.modalAbierto = false;
  }

  toggleModal(event: MouseEvent): void {
    if (event.target === event.currentTarget) {
      this.cerrarModal();
    }
  }

}
