import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { NgForm, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-producto-edicion',
  imports: [FormsModule],
  templateUrl: './view-producto-edicion.html',
  styleUrl: './view-producto-edicion.css',
})
export class ViewProductoEdicion {

  private route = inject(ActivatedRoute);
  productoId!: Number;

  private router = inject(Router);
  producto : any;
  
  ngOnInit(): void {
    this.productoId = Number(
      this.route.snapshot.paramMap.get('id')
    );
    this.producto = history.state.producto||{nombre:'',precio:''};
  }

  
  onActualizar(form: NgForm) {
    console.log('Data del formulario:', form.value);
    console.log('Data del producto:', this.producto);
    this.router.navigate(['/productos']);
  }

  onCancelar() {
    this.router.navigate(['/productos']);
  }
}
