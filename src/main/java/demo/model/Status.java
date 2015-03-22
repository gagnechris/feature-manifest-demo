package demo.model;

public class Status {

  private final String status;
  private final String description;

  public Status(String status, String description) {
    this.status = status;
    this.description = description;
  }

  public String getStatus() {
    return this.status;
  }

  public String getDescription() {
    return this.description;
  }
}