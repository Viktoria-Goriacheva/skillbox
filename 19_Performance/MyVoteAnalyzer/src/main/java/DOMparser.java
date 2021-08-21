import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMparser {

  private final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

  private final HashMap<Integer, WorkTime> voteStationWorkTimes;
  private final HashMap<String, Integer> voterCounts;

  public DOMparser() {
    voteStationWorkTimes = new HashMap<>();
    voterCounts = new HashMap<>();
  }

  public void parseFile(String fileName) throws Exception {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File(fileName));

    findEqualVoters(doc);
    fixWorkTimes(doc);
  }

  private void findEqualVoters(Document doc) throws ParseException {
    NodeList voters = doc.getElementsByTagName("voter");
    int votersCount = voters.getLength();
    for (int i = 0; i < votersCount; i++) {
      Node node = voters.item(i);
      NamedNodeMap attributes = node.getAttributes();

      String voter = attributes.getNamedItem("name").getNodeValue().concat(" (")
          .concat(attributes.getNamedItem("birthDay").getNodeValue().concat(")"));

      Integer count = voterCounts.get(voter);
      voterCounts.put(voter, count == null ? 1 : count + 1);
    }
  }

  private void fixWorkTimes(Document doc) throws ParseException {
    NodeList visits = doc.getElementsByTagName("visit");
    int visitCount = visits.getLength();
    for (int i = 0; i < visitCount; i++) {
      Node node = visits.item(i);
      NamedNodeMap attributes = node.getAttributes();

      Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
      long time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue()).getTime();
      WorkTime workTime = voteStationWorkTimes.get(station);
      if (workTime == null) {
        workTime = new WorkTime();
        voteStationWorkTimes.put(station, workTime);
      }
      workTime.addVisitTime(time);
    }
  }

  public void printWorkTimes() {
    for (Integer st : voteStationWorkTimes.keySet()) {
      WorkTime wt = voteStationWorkTimes.get(st);
      System.out.println("\t" + st + " - " + wt);
    }
  }

  public void printDuplicatedVoters() {
    for (String voter : voterCounts.keySet()) {
      int count = voterCounts.get(voter);
      if (count > 1) {
        System.out.println(voter.concat(" - ") + count);
      }
    }
  }
}
