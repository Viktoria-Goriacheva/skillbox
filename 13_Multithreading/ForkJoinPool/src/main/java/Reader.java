import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Reader extends RecursiveTask<Set<String>> {

  @Getter
  private String url;
  @Getter
  private static Set<String> allLinks = Collections.synchronizedSet(new TreeSet<>());


  public Reader(String url) {
    this.url = url;
  }

  @Override
  protected Set<String> compute() {
    List<Reader> taskList = new ArrayList<>();
    for (String link : getChildrens(getUrl())) {
      Reader reader = new Reader(link);
      reader.fork();
      taskList.add(reader);
    }
    taskList.forEach(Reader::join);
    return allLinks;
  }

  private Set<String> getChildrens(String url) {
    Document doc;
    Set<String> links = new TreeSet<>();

    try {
      Thread.sleep(200);
      doc = Jsoup.connect(url).maxBodySize(0).get();
      Elements elements = doc.select("a[href]");

      for (Element element : elements) {
        String link = element.absUrl("href");
        if (link.startsWith(url) && link.endsWith("/") && addNewURL(link)) {
          links.add(link);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return links;
  }

  private synchronized boolean addNewURL(String url) {
    return allLinks.add(url);
  }
}

