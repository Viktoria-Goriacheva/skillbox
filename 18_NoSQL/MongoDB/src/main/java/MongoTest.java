import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.function.Consumer;
import org.bson.BsonDocument;
import org.bson.Document;

public class MongoTest {

  private static final String PATH = "D:/Skillbox/java_basics/18_NoSQL/MongoDB/src/main/resources/mongo.csv";
  private static final String IMPORT_PATH = "C:/Users/grumb/AppData/Local/Programs/mongodb-database-tools-windows-x86_64-100.4.1/bin/mongoimport.exe";

  public static void main(String[] args) {
    ImportDB();
    MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    MongoDatabase dbs = mongoClient.getDatabase("StudentsCol");
    MongoCollection<Document> collection = dbs.getCollection("students");

    System.out.println("Total students count in database " + collection.countDocuments()
        + "\n*************************");

    BsonDocument query = BsonDocument.parse("{age: {$gt: 40}}");
    System.out.println("Count of students older than 40 years : " + collection.countDocuments(query)
        + "\n*************************");

    query = BsonDocument.parse("{age: 1}");
    collection.find().sort(query).limit(1)
        .forEach((Consumer<Document>) document -> System.out.println(
            "Name the youngest student : " + document.get("name")
                + "\n*************************"));

    query = BsonDocument.parse("{age: -1}");
    collection.find().sort(query).limit(1)
        .forEach((Consumer<Document>) document -> System.out.println(
            "Courses the oldest student : " + document.get("courses")
                + "\n*************************"));
  }


  public static void ImportDB() {
    Runtime r = Runtime.getRuntime();
    String command =
        IMPORT_PATH
            + " --db=StudentsCol --collection=students --type=csv --fields=name,age,courses --drop --file="
            + PATH;
    try {
      r.exec(command);
      System.out.println("Reading csv into Database");

    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }
  }
}
