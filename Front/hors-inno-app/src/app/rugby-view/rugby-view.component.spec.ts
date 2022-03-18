import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RugbyViewComponent } from './rugby-view.component';

describe('RugbyViewComponent', () => {
  let component: RugbyViewComponent;
  let fixture: ComponentFixture<RugbyViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RugbyViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RugbyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
