import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXparser extends DefaultHandler {

  String birthDay;
  String name;

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    try {
      if (qName.equals("voter") && name == null) {
        birthDay = attributes.getValue("birthDay").replace('.', '-');
        name = attributes.getValue("name");
      } else if (qName.equals("visit") && name != null) {
        DBConnection.countVoter(name, birthDay);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void endElement(String uri, String localName, String qName) {
    if (qName.equals("voter")) {
      name = null;
    } else if (qName.equals("voters")) {
      try {
        DBConnection.executeMultiInsert();
      } catch (SQLException sqle) {
        sqle.printStackTrace();
      }
    }
  }
}
