import { CPUModel } from 'services/cpu/cpu.model';
import { GPUModel } from 'services/gpu/gpu.model';
import { MotherboardModel } from 'services/motherboard/motherboard.model';
import { PowerSupplyModel } from 'services/power-supply/PowerSupply.model';
import { RAMModel } from 'services/ram/RAM.model';
import { StorageModel } from 'services/storage/storage.model';

export interface PCBuildModel {
  cpu: CPUModel;
  gpu: GPUModel;
  ram: RAMModel;
  motherboard: MotherboardModel;
  powerSupply: PowerSupplyModel;
  storage: Array<StorageModel>;
}
