import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { WebClient } from '../webclient';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-ward',
  imports: [CommonModule,FormsModule],
  templateUrl: './ward.html',
  styleUrl: './ward.scss'
})
export class Ward {
  model: any = {
      ward_name: '',
      ward_type: '',
      floor_number: null
  };

  constructor(private webclient : WebClient){}
  // Options for the ward_type dropdown
  wardTypes = ['General', 'ICU', 'Pediatric', 'Maternity'];

  // The submit function receives the form instance from the template
  onSubmit(form: NgForm): void {
    if (form.invalid) {
      // Don't submit if the form is not valid
      return;
    }
    this.webclient.post<any,any>("saveward",this.model)
    .then((res)=>{
      console.log(res)
    })
    .catch((err)=>{

    })

    // Here you would send 'this.model' to your backend API service
    // e.g., this.wardService.createWard(this.model).subscribe(...);
  }
}
