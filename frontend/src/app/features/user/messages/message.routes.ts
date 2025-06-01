import { Routes } from '@angular/router';

export const messageRoutes: Routes = [
    {
        path: '',
        title: 'Messages',
        loadComponent: () => import('./messages.component').then(m => m.MessagesComponent)
    }
];
