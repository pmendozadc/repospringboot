import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProductoEdicion } from './view-producto-edicion';

describe('ViewProductoEdicion', () => {
  let component: ViewProductoEdicion;
  let fixture: ComponentFixture<ViewProductoEdicion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewProductoEdicion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewProductoEdicion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
