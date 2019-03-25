import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitComposeComponent } from './twit-compose.component';

describe('TwitComposeComponent', () => {
  let component: TwitComposeComponent;
  let fixture: ComponentFixture<TwitComposeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwitComposeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitComposeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
