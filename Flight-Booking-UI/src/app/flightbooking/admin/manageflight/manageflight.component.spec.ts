import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageflightComponent } from './manageflight.component';

describe('ManageflightComponent', () => {
  let component: ManageflightComponent;
  let fixture: ComponentFixture<ManageflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
