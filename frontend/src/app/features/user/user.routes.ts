import { Routes } from '@angular/router';
import { messageRoutes } from './messages/message.routes';

export const userRoutes: Routes = [
    {
        path: '',
        title: 'User',
        loadComponent: () => import('./user.component').then(m => m.UserComponent)
    },
    {
        path: 'messages',
        children: messageRoutes
    }
];
