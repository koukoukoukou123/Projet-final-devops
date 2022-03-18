import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HandballViewComponent } from './handball-view.component';

describe('HandballViewComponent', () => {
  let component: HandballViewComponent;
  let fixture: ComponentFixture<HandballViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HandballViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HandballViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
