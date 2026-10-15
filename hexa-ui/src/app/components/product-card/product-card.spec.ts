import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductCard } from './product-card';
import { ProductService } from '../../services/product/product-service';
import { Product } from '../../models/product';
import { of } from 'rxjs/internal/observable/of';

describe('ProductCard', () => {
  let component: ProductCard;
  let fixture: ComponentFixture<ProductCard>;
  const books: Array<Product> = [{
              "id": 1,
              "name": "Clean Code",
              "price": 10.99,
              "description": "By Robert C. Martin",
              "URI": "./clean_code.jpg",
              "quantity": 100
            }];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductCard],
      providers: [
        {
          provide: ProductService,
          useValue: {
            getImageURL: vi.fn(),
            getProducts: () => vi.fn().mockReturnValue(of(books)),
          },
        },
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(ProductCard);
    component = fixture.componentInstance;
    component.product = books[0];
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getImageURL with the product ID', () => {
    component.ngOnInit();
    expect(component['productService'].getImageURL).toHaveBeenCalledWith(books[0].id);
  });
});
