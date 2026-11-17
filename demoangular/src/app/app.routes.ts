import { Routes } from '@angular/router';
import { ViewProductos } from './cu/administrar-productos/view-productos/view-productos';
import { ViewProductoNuevo } from './cu/administrar-productos/view-producto-nuevo/view-producto-nuevo'
import { ViewProductoEdicion } from './cu/administrar-productos/view-producto-edicion/view-producto-edicion'

export const routes: Routes = [
    {
        path:'productos', component: ViewProductos,title  :'Vista de productos' 
    },
    {
        path:'producto/nuevo', component: ViewProductoNuevo,title  :'Vista de producto nuevo' 
    },

    {
    path: 'producto/:id',
    component: ViewProductoEdicion
    }
];
