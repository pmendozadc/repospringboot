import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-producto-edicion',
  imports: [],
  templateUrl: './view-producto-edicion.html',
  styleUrl: './view-producto-edicion.css',
})
export class ViewProductoEdicion {

  private route = inject(ActivatedRoute);

  productoId = this.route.snapshot.paramMap.get('id');
}
