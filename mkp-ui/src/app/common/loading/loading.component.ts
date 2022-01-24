import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { Subscription } from 'rxjs';
import { LoadingService } from './loading.service';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css']
})
export class LoadingComponent implements OnInit {

  loading: boolean = false;
  loadingSubscription: Subscription | undefined;

  constructor(
    private loadingService: LoadingService,
    private spinner: NgxSpinnerService) {
  }

  ngOnInit() {
    this.loadingSubscription = this.loadingService.loadingStatus.subscribe((value) => {
      this.loading = value;
      if(value){
        this.spinner.show();
      }else{
        this.spinner.hide();
      }
    });
  }

  ngOnDestroy() {
    if(this.loadingSubscription){
      this.loadingSubscription.unsubscribe();
    }
  }

}
