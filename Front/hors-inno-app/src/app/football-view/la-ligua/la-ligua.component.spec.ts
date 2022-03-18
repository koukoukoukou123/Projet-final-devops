import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaLiguaComponent } from './la-ligua.component';

describe('LaLiguaComponent', () => {
  let component: LaLiguaComponent;
  let fixture: ComponentFixture<LaLiguaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaLiguaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaLiguaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
