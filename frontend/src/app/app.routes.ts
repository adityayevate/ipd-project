import { Routes } from '@angular/router';
import { Header } from './header/header';
import { App } from './app';
import { Ward } from './ward/ward';

export const routes: Routes = [
    {path : "",component : App},
        {path : "home",component : Header},
    {path : "ward" , component : Ward}
];
