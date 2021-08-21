import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/* SAX грузит в базу файл на 1572Мб 178 сек.
   -------------------------------------------
*/
public class Loader {

  private static final String FILE_NAME = "src/main/resources/data-1572M.xml";

  public static void main(String[] args) throws Exception {
    parseSAX(FILE_NAME);
    DBConnection.printVoterCounts();
  }

  private static void parseSAX(String file) throws Exception {
    long start = System.currentTimeMillis();
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    SAXparser handler = new SAXparser();
    parser.parse(new File(FILE_NAME), handler);
    long end = System.currentTimeMillis() - start;
    System.out.println("Parsing time: " + end);
  }

  private static void parseDOM(String file) throws Exception {
    DOMparser domparser = new DOMparser();
    domparser.parseFile(FILE_NAME);
  }
}