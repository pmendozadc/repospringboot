import { Component ,input, output } from '@angular/core';

@Component({
  selector: 'app-modal-producto',
  imports: [],
  templateUrl: './modal-producto.html',
  styleUrl: './modal-producto.css',
})
export class ModalProducto {

  producto = input<any>();

  cerrar = output<void>();

}
