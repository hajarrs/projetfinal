import { TestBed } from '@angular/core/testing';

import { GoupeclasseService } from './goupeclasse.service';

describe('GoupeclasseService', () => {
  let service: GoupeclasseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoupeclasseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
