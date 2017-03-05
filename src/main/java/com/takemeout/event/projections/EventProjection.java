package com.takemeout.event.projections;

public class EventProjection {
  private int id;
  private int userId;
  private String name;
  private String time;
  private String clock;
  private String type;
  private String description;
  private String access;
  private String location;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public int getUserId() { return userId; }
  public void setUserId(int userId) { this.userId = userId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getClock() { return clock; }
  public void setClock(String clock) { this.clock = clock; }

  public String getTime() { return time; }
  public void setTime(String time) { this.time = time; }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getAccess() {return access; }
  public void setAccess(String access) { this.access = access; }

  public String getLocation() { return location; }
  public void setLocation(String location) { this.location = location; }
}
