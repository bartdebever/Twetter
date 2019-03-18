import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitViewerComponent } from './twit-viewer.component';

describe('TwitViewerComponent', () => {
  let component: TwitViewerComponent;
  let fixture: ComponentFixture<TwitViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwitViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
