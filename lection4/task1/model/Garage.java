package com.senla.project.model;

import java.util.List;
import java.util.ArrayList;

public class Garage {
private int id;
private List <WorkPlace> workplace = new ArrayList<WorkPlace>();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<WorkPlace> getWorkplace() {
	return workplace;
}
@Override
public String toString() {
	return "Garage [id=" + id + ", workplace=" + workplace + "]";
}



}
