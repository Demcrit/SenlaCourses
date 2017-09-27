package com.senla.project.realization;

import java.util.Date;
import com.senla.project.managers.MechanicManager;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Task;
import com.senla.project.model.WorkPlace;

public class Runner {

	private static MechanicManager mn = new MechanicManager();

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Task task1 = new Task("Change oil",new Date(2017,12,11),new Date(04,12,2013),new Date(11,12,2013),3.43);
		System.out.println(task1.toString());
		
		WorkPlace workplace1 = new WorkPlace();
		Mechanic mechanic = new Mechanic(1,"Guy Montag",null);
		Mechanic mechanic1 = new Mechanic(2,"Aorst Ever",null);
		Mechanic mechanic2 = new Mechanic(3,"Best test",null);
		mn.addMechanic(mechanic);
		mn.addMechanic(mechanic1);
		mn.addMechanic(mechanic2);
		System.out.print(mn.sortMechanicsByName());
		mn.getAllMechanics();	
		mn.findFreeMechanic();
		Order order1 = new Order(mechanic1,workplace1,task1);
		System.out.println(order1.toString());
		
	}

}
