import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ligue2Component } from './ligue2.component';

describe('Ligue2Component', () => {
  let component: Ligue2Component;
  let fixture: ComponentFixture<Ligue2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ligue2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ligue2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
