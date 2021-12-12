package org.launchcode.techjobs.oo;

import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.



    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public Job(){
        id = nextId;
        nextId++;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
//        String noJobString = "OOPS! This job does not seem to exist.";
        String dataNot= "Data not available";
        ArrayList<Object> postProcessedList = new ArrayList<>();
        ArrayList<Object> toStringRefCheckNoID = new ArrayList<>();
        ArrayList<String> nameArr = new ArrayList<>();

 //       toStringRefCheckNoID.add(this.getName());
        toStringRefCheckNoID.add(this.getEmployer().getValue());
        toStringRefCheckNoID.add(this.getLocation().getValue());
        toStringRefCheckNoID.add(this.getPositionType().getValue());
        toStringRefCheckNoID.add(this.getCoreCompetency().getValue());

        if (this.getName()=="" || this.getName() == null){
            nameArr.add( dataNot);
        } else {
            nameArr.add(this.getName());
        }

        for (int i=0; i<toStringRefCheckNoID.size(); i++){
            if (toStringRefCheckNoID.get(i) == "" || toStringRefCheckNoID.get(i) == null){
               postProcessedList.add(dataNot);
            } else {
                postProcessedList.add(toStringRefCheckNoID.get(i));
            }
        }
//        if (nameArr.get(0) == dataNot
//                && postProcessedList.get(0) == dataNot
//                && postProcessedList.get(1) == dataNot
//                && postProcessedList.get(2) == dataNot
//                && postProcessedList.get(3) == dataNot){
//            return noJobString;
//        }
        String printOut ="\nID: " + this.getId()
                + "\nName: " + nameArr.get(0)
                + "\nEmployer: " + postProcessedList.get(0)
                + "\nLocation: " + postProcessedList.get(1)
                + "\nPosition Type: " + postProcessedList.get(2)
                + "\nCore Competency: " + postProcessedList.get(3) + "\n";



        return printOut;
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
