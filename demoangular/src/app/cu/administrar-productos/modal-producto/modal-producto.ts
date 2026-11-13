import { Component ,input, output } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modal-producto',
  imports: [FormsModule],
  templateUrl: './modal-producto.html',
  styleUrl: './modal-producto.css',
})
export class ModalProducto {

  producto = input<any>();
  cerrar = output<void>();

  onGuardar(form: NgForm) {
    console.log('Data del formulario:', form.value);
  }
}
