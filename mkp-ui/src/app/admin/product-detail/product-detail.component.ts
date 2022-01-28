import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/interface/product';
import { ProductService } from 'src/app/service/product.service';
import { ProductListComponent } from '../product-list/product-list.component';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  product:Product={
    id:'',
    name:'',
    description:'',
    price:0
  };

  constructor(private productService:ProductService,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.product.id = params['id'];
      if(this.product.id){
        this.productService.getAdminProduct(this.product.id).subscribe((res)=>{
          this.product = res;
        });
      }
    });
  }

  onSubmit(){
    this.productService.saveAdminProduct(this.product).subscribe((res)=>{
      alert("Save Success!");
    });
  }

}
