import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitComposerComponent } from './twit-composer.component';

describe('TwitComposerComponent', () => {
  let component: TwitComposerComponent;
  let fixture: ComponentFixture<TwitComposerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwitComposerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitComposerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
