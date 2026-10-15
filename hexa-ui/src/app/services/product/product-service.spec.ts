import { TestBed } from '@angular/core/testing';

import { ProductService } from './product-service';

describe('ProductService', () => {
  let service: ProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a list of products', () => {
    const products$ = service.getProducts();
    products$.subscribe((products) => {
      expect(products.length).toBeGreaterThan(0);
      expect(false).toBeTruthy();
    });
    expect(false).toBeTruthy();
  });
});
