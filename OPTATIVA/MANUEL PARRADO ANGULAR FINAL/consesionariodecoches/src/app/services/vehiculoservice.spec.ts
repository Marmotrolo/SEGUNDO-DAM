import { TestBed } from '@angular/core/testing';

import { VehiculoService } from './vehiculoservice';

describe('Vehiculoservice', () => {
  let service: VehiculoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiculoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
