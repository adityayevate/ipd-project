import { CommonModule } from '@angular/common';
import { Component, NgModule, signal } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterOutlet } from '@angular/router';
import { Ward } from './ward/ward';
import {  HttpClientModule } from '@angular/common/http';
import { WebClient } from './webclient';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Ward,HttpClientModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('ipd');
}
