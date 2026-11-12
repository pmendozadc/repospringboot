import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTemplateDemo } from './form-template-demo';

describe('FormTemplateDemo', () => {
  let component: FormTemplateDemo;
  let fixture: ComponentFixture<FormTemplateDemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormTemplateDemo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormTemplateDemo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
