import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketballViewComponent } from './basketball-view.component';

describe('BasketballViewComponent', () => {
  let component: BasketballViewComponent;
  let fixture: ComponentFixture<BasketballViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BasketballViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BasketballViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
