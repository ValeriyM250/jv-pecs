package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {

    private final MachineProducer truckProducer = new MachineProducer() {
        @Override
        public List<Machine> get() {
            Truck truck1 = new Truck();
            Truck truck2 = new Truck();
            Truck truck3 = new Truck();
            List<Machine> trucks = List.of(truck1, truck2, truck3);
            return trucks;
        }
    };

    private final MachineProducer excavatorProducer = new MachineProducer() {
        @Override
        public List<Machine> get() {
            Excavator excavator1 = new Excavator();
            Excavator excavator2 = new Excavator();
            Excavator excavator3 = new Excavator();
            List<Machine> excavators = List.of(excavator1, excavator2, excavator3);
            return excavators;
        }
    };

    private final MachineProducer bulldozerProducer = new MachineProducer() {
        @Override
        public List<Machine> get() {
            Bulldozer bulldozer1 = new Bulldozer();
            Bulldozer bulldozer2 = new Bulldozer();
            Bulldozer bulldozer3 = new Bulldozer();
            List<Machine> bulldozers = List.of(bulldozer1, bulldozer2, bulldozer3);
            return bulldozers;
        }
    };

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {

        switch (type.getSimpleName()) {
            case "Truck":
                return truckProducer.get();
            case "Bulldozer":
                return bulldozerProducer.get();
            case "Excavator":
                return excavatorProducer.get();
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (int i = 0; i < machines.size(); i++) {
            machines.get(i).doWork();
        }
    }
}
