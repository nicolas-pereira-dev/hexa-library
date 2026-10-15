import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBasket } from './user-cart';

describe('UserBasket', () => {
  let component: UserBasket;
  let fixture: ComponentFixture<UserBasket>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserBasket],
    }).compileComponents();

    fixture = TestBed.createComponent(UserBasket);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
