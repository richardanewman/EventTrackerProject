import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BitfolioComponent } from './bitfolio.component';

describe('BitfolioComponent', () => {
  let component: BitfolioComponent;
  let fixture: ComponentFixture<BitfolioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BitfolioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BitfolioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
