import { Routes } from '@angular/router';
import { ViewProductos } from './cu/administrar-productos/view-productos/view-productos';

export const routes: Routes = [
    {
        path:'productos', component: ViewProductos,title  :'Vista de productos' 
    }
];
