package com.senla.runner;

import com.senla.exceptions.NoSuchDataException;
import com.senla.facade.Facade;

public class Runner {

	public static void main(String[] args) throws ReflectiveOperationException, NoSuchDataException {
    Facade.getInstance().getAll();		

	}

}
