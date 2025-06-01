import { Routes } from '@angular/router';
import { userRoutes } from './features/user/user.routes';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '',
        pathMatch: 'full'
    },
    {
        path: 'login',
        title: 'Login',
        loadComponent: () => import('./auth/login/login.component').then(m => m.LoginComponent)
    },
    {
        path: 'user',
        children: userRoutes  // Gắn route con
    }
];
