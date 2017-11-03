package com.senla.project.ui.actions;

import java.text.ParseException;
import java.util.List;
import com.senla.project.facade.Facade;
import com.senla.project.model.Workplace;
import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;
import static com.senla.project.ui.utils.GeneralScanner.*;

public class FreePlaceInDateAction implements IAction {

	private static final String PARSE_ERROR = "Parse Error";
	private static final String INPUT_DATE = "Input Date:";

	@Override
	public void execute() {

		printMessage(INPUT_DATE);
		try {
			int mechanicsStateCount = Facade.getInstance().getAll().size();
			List<Workplace> list = Facade.getInstance().getFreePlacesInDate(parseDate(nextLine()));

			// if mechanics count are less than all places return mechanics
			if (mechanicsStateCount > list.size()) {
				printObject(list.size());
			} else {
				printObject(mechanicsStateCount);
			}
		} catch (ParseException e) {
			printMessage(PARSE_ERROR);
		}

	}

}
