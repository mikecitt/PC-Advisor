package com.pcadvisor.pcadvisorapi.rule;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.pcadvisor.pcadvisorapi.dto.AffinitiesDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.CPUBrand;
import com.pcadvisor.pcadvisorapi.model.GPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.model.PCBuild;
import com.pcadvisor.pcadvisorapi.model.PowerSupply;
import com.pcadvisor.pcadvisorapi.model.RAM;
import com.pcadvisor.pcadvisorapi.model.RamType;
import com.pcadvisor.pcadvisorapi.model.Storage;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import com.pcadvisor.pcadvisorapi.repository.GPURepository;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import com.pcadvisor.pcadvisorapi.repository.PowerSupplyRepository;
import com.pcadvisor.pcadvisorapi.repository.RAMRepository;
import com.pcadvisor.pcadvisorapi.repository.StorageRepository;

import org.drools.core.ObjectFilter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PCBuildRulesUnitTests {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private PowerSupplyRepository powerSupplyRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private StorageRepository storageRepository;

    private KieSession session;

    @Test
    public void testGetBuilds() {
        KieSession session = kieContainer.newKieSession("rulesSession");

        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 5);
        AffinitiesDTO affinitiesDTO = new AffinitiesDTO(null, null, 900);
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Storage> storages = storageRepository.findAll();
        List<Motherboard> motherboards = motherboardRepository.findAll();
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        session.insert(priorityDTO);
        session.insert(affinitiesDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        for(GPU gpu: gpus)
            session.insert(gpu);
        for(RAM ram: rams)
            session.insert(ram);
        for(Storage storage: storages)
            session.insert(storage);
        for(Motherboard motherboard: motherboards)
            session.insert(motherboard);
        for(PowerSupply powerSupply: powerSupplies)
            session.insert(powerSupply);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("finish").setFocus();
        session.fireAllRules();
        System.out.println("DONE");

        ObjectFilter pcBuildFilter = new ObjectFilter() {

            @Override
            public boolean accept(Object object) {
                if (PCBuild.class.equals(object.getClass()))
                    return true;
                if (PCBuild.class.equals(object.getClass().getSuperclass()))
                    return true;
                return false;
            }
        };
        Collection<?> objects = session.getObjects(pcBuildFilter);
        for (Iterator i = objects.iterator(); i.hasNext(); )
            System.out.println(i.next());
        session.dispose();
        Assert.assertTrue(objects.size() > 0);
    }

    @Test
    public void testGetBuildsBrandPref() {
        KieSession session = kieContainer.newKieSession("rulesSession");

        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 5);
        AffinitiesDTO affinitiesDTO = new AffinitiesDTO(CPUBrand.AMD, 450, 900);
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Motherboard> motherboards = motherboardRepository.findAll();
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        session.insert(priorityDTO);
        session.insert(affinitiesDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        for(GPU gpu: gpus)
            session.insert(gpu);
        for(RAM ram: rams)
            session.insert(ram);
        for(Motherboard motherboard: motherboards)
            session.insert(motherboard);
        for(PowerSupply powerSupply: powerSupplies)
            session.insert(powerSupply);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("finish").setFocus();
        session.fireAllRules();
        System.out.println("DONE");

        ObjectFilter pcBuildFilter = new ObjectFilter() {

            @Override
            public boolean accept(Object object) {
                if (PCBuild.class.equals(object.getClass()))
                    return true;
                if (PCBuild.class.equals(object.getClass().getSuperclass()))
                    return true;
                return false;
            }
        };
        Collection<?> objects = session.getObjects(pcBuildFilter);
        for (Iterator i = objects.iterator(); i.hasNext(); )
            System.out.println(i.next());
        session.dispose();
        Assert.assertTrue(objects.size() > 0);
    }

    @Test
    public void testNotEnoughBudget() {
        KieSession session = kieContainer.newKieSession("rulesSession");

        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 7);
        AffinitiesDTO affinitiesDTO = new AffinitiesDTO(CPUBrand.AMD, 450, 300);
        Integer initBudget = affinitiesDTO.getBudget();
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Motherboard> motherboards = motherboardRepository.findAll();
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        session.insert(priorityDTO);
        session.insert(affinitiesDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        for(GPU gpu: gpus)
            session.insert(gpu);
        for(RAM ram: rams)
            session.insert(ram);
        for(Motherboard motherboard: motherboards)
            session.insert(motherboard);
        for(PowerSupply powerSupply: powerSupplies)
            session.insert(powerSupply);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("finish").setFocus();
        session.fireAllRules();
        session.dispose();
        Assert.assertTrue(initBudget < affinitiesDTO.getBudget());
        
    }

    @Test
    public void testPSUChoose() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(1L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(1L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        session.insert(pcBuild);
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        for(PowerSupply powerSupply: powerSupplies)
            session.insert(powerSupply);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertTrue(pcBuild.getPowerUsage() <= (pcBuild.getPowerSupply().getWattage() + 300));
        session.dispose();
    }

    @Test
    public void testRAMChooseAMD() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(1L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(1L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        PriorityDTO priorityDTO = new PriorityDTO(5, 4, 5);
        session.insert(pcBuild);
        session.insert(priorityDTO);
        List<RAM> rams = ramRepository.findAll();
        for(RAM ram: rams)
            session.insert(ram);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertTrue(pcBuild.getRam().getSize() >= (priorityDTO.getRamPriority() * 8 / 5));
        Assert.assertTrue(pcBuild.getRam().getRamType() == RamType.KIT);
        session.dispose();
    }

    @Test
    public void testRAMChooseINTEL() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(2L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(3L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        PriorityDTO priorityDTO = new PriorityDTO(5, 4, 5);
        session.insert(pcBuild);
        session.insert(priorityDTO);
        List<RAM> rams = ramRepository.findAll();
        for(RAM ram: rams)
            session.insert(ram);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertTrue(pcBuild.getRam().getSize() >= (priorityDTO.getRamPriority() * 8 / 5));
        Assert.assertTrue(pcBuild.getRam().getRamType() == RamType.SINGLE);
        session.dispose();
    }

    @Test
    public void testStorageChooseNoParams() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(2L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(3L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        session.insert(pcBuild);
        session.insert(new AffinitiesDTO());
        List<Storage> storages = storageRepository.findAll();
        for(Storage storage: storages)
            session.insert(storage);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertTrue(pcBuild.getStorage().size() > 0);
        session.dispose();
    }

    @Test
    public void testStorageChooseSSD() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(2L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(3L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        session.insert(pcBuild);
        session.insert(new AffinitiesDTO(null, 450, null));
        List<Storage> storages = storageRepository.findAll();
        for(Storage storage: storages)
            session.insert(storage);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertEquals(1, pcBuild.getStorage().size());
        Assert.assertTrue(pcBuild.getStorage().get(0).getSize() >= 450);
        System.out.println(pcBuild);
        session.dispose();
    }

    @Test
    public void testStorageChooseSSDandHDD() {
        session = kieContainer.newKieSession("rulesSession");
        CPU cpu = cpuRepository.findById(2L).orElseGet(null);
        Motherboard motherboard = motherboardRepository.findById(3L).orElseGet(null);
        GPU gpu = gpuRepository.findById(1L).orElseGet(null);
        PCBuild pcBuild = new PCBuild(cpu, motherboard, gpu);
        session.insert(pcBuild);
        session.insert(new AffinitiesDTO(null, 1400, null));
        List<Storage> storages = storageRepository.findAll();
        for(Storage storage: storages)
            session.insert(storage);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        Assert.assertEquals(2, pcBuild.getStorage().size());
        Integer total = 0;
        for(Storage s: pcBuild.getStorage())
            total += s.getSize();
        Assert.assertTrue(total >= 1400);
        System.out.println(pcBuild);
        session.dispose();
    }
}
