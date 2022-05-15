package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

  private final int id;
  private static int nextId = 1;
  private String name;
  private Employer employer;
  private Location location;
  private PositionType positionType;
  private CoreCompetency coreCompetency;

  // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
  //  other five fields. The second constructor should also call the first in order to initialize
  //  the 'id' field.
  public Job() {
    id = nextId;
    nextId++;
  }

  public Job(
      String aName,
      Employer aEmployer,
      Location aLocation,
      PositionType aPositionType,
      CoreCompetency aCoreCompetency) {
    this();
    this.name = aName;
    this.employer = aEmployer;
    this.location = aLocation;
    this.positionType = aPositionType;
    this.coreCompetency = aCoreCompetency;
  }

  // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id
  // fields
  //  match.

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Job job = (Job) o;
    return getId() == job.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
  //  and id.

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

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    Object[] objectsArrayIndirect = {
      String.valueOf(getName()),
      getEmployer(),
      getLocation(),
      getPositionType(),
      getCoreCompetency()
    };
    String[] valuesArrayIndirect = {
      String.valueOf(name),
      getEmployer().getValue(),
      getLocation().getValue(),
      getPositionType().getValue(),
      getCoreCompetency().getValue()
    };

    int nullCounter = 0;
    int i = 0;
    while (i < objectsArrayIndirect.length) {
      if (valuesArrayIndirect[i].isEmpty() || Objects.equals(valuesArrayIndirect[i], "")) {
        if (objectsArrayIndirect[i].getClass().toString().equals("class java.lang.String")) {
          this.name = "Data not available";
          nullCounter++;
        } else if (objectsArrayIndirect[i]
            .getClass()
            .toString()
            .equals("class org.launchcode.techjobs.oo.Employer")) {
          this.employer = new Employer("Data not available");
          nullCounter++;
        } else if (objectsArrayIndirect[i]
            .getClass()
            .toString()
            .equals("class org.launchcode.techjobs.oo.Location")) {
          this.location = new Location("Data not available");
          nullCounter++;
        } else if (objectsArrayIndirect[i]
            .getClass()
            .toString()
            .equals("class org.launchcode.techjobs.oo.PositionType")) {
          this.positionType = new PositionType("Data not available");
          nullCounter++;
        } else if (objectsArrayIndirect[i]
            .getClass()
            .toString()
            .equals("class org.launchcode.techjobs.oo.CoreCompetency")) {
          this.coreCompetency = new CoreCompetency("Data not available");
          nullCounter++;
        }
      }
      i++;
    }
    if (nullCounter == objectsArrayIndirect.length && getId() > 0) {
      return "OOPS! This job does not seem to exist.";
    } else {
      return "\n"
          + "ID: "
          + getId()
          + "\n"
          + "Name: "
          + getName()
          + "\n"
          + "Employer: "
          + getEmployer().getValue()
          + "\n"
          + "Location: "
          + getLocation().getValue()
          + "\n"
          + "Position Type: "
          + getPositionType().getValue()
          + "\n"
          + "Core Competency: "
          + getCoreCompetency().getValue()
          + "\n";
    }
  }
}
