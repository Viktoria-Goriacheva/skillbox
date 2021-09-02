public class Station {

  private String numberLine;
  private String name;

  public Station(String numberLine, String name) {
    this.numberLine = numberLine;
    this.name = name;
  }

  public String getNumberLine() {
    return numberLine;
  }

  public void setNumberLine(String numberLine) {
    this.numberLine = numberLine;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
