package com.senla.project.ui.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.facade.Facade;
import com.senla.project.model.Workplace;
import com.senla.project.ui.api.IAction;
import static com.senla.project.ui.utils.GeneralScanner.*;

public class NearestFreeDateAction implements IAction {

	@Override
	public void execute() {
		Date date = parseTodayDate();
		Calendar cal = Calendar.getInstance();
		List<Workplace> list = new ArrayList<>();

		while (true) {

			list = Facade.getFACADE().getFreePlacesInDate(date);
			if (list.isEmpty()) {

				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, 1);
				date = cal.getTime();
			} else {
				break;
			}
		}

		printObject(date);

	}

}
