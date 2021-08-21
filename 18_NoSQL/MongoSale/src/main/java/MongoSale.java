import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

public class MongoSale {

  private MongoClient mongoClient;
  private MongoDatabase dbs;
  private MongoCollection<Document> goods;
  private MongoCollection<Document> shops;
  public static final int COST_LIMIT = 100;

  public MongoSale() {
    mongoClient = new MongoClient("127.0.0.1", 27017);
    dbs = mongoClient.getDatabase("collection");
    goods = dbs.getCollection("goods");
    shops = dbs.getCollection("shops");
  }

  public void addGoods(String good, String cost) {
    Document document = new Document().append("name_good", good)
        .append("cost", Integer.valueOf(cost));
    goods.insertOne(document);
    System.out.println("Товар " + good + " по цене " + cost + " добавлен");
  }

  public void addShops(String shop) {
    Document document = new Document().append("name_shop", shop)
        .append("goods", new ArrayList<String>());
    shops.insertOne(document);
    System.out.println("Магазин " + shop + " создан");
  }

  public void putOutGoods(String good, String shop) {
    Document document = shops.find(eq("name_shop", shop)).first();
    ArrayList<String> productsList = (ArrayList<String>) document.get("goods");
    BsonDocument query = BsonDocument.parse("{name_good: " + "\"" +
        good + "\"" + "}");
    if (!productsList.contains(good) && !(goods.countDocuments(query) == 0)) {
      productsList.add(good);
      shops.findOneAndUpdate(eq("name_shop", shop),
          new Document("$set", new Document("goods", productsList)));
      System.out.println("Товар " + good + " выставлен в магазин " + shop);
    } else {
      System.out.println("Товара " + good + " нет на складе");
    }
  }

  public void getStatistics() {
    System.out.println("******************************");
    AggregateIterable result = shops.aggregate(Arrays.asList(
        lookup("goods", "goods", "name_good", "cost_info"),
        unwind("$cost_info"),
        group("$name_shop",
            sum("goodsCount", 1),
            avg("AvgPrice", "$cost_info.cost"),
            max("MaxPrice", "$cost_info.cost"),
            min("MinPrice", "$cost_info.cost"),
            sum("lessThen100Count",BsonDocument.parse("{$cond:[{ $lt:[ \"$cost_info.cost\", 100 ]}, 1, 0]}")))
    ));
    System.out.println("Статистика по магазинам : " + "\n");

    result.forEach((Consumer<Document>) doc -> {
      System.out
          .println(doc.toJson(JsonWriterSettings.builder().outputMode(JsonMode.SHELL).build()));
    });
  }

  public void colCleaner() {
    shops.deleteMany(new Document());
    goods.deleteMany(new Document());
  }

  public void allDrop() {
    dbs.drop();
  }
}
