import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisStorage {

  private RedissonClient redisson;
  private RKeys rKeys;
  private RScoredSortedSet<String> onlineUsers;
  private final static String KEY = "ONLINE_USERS";

  void init() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    try {
      redisson = Redisson.create(config);
    } catch (RedisConnectionException Exc) {
      System.out.println("Не удалось подключиться к Redis");
      System.out.println(Exc.getMessage());
    }
    rKeys = redisson.getKeys();
    onlineUsers = redisson.getScoredSortedSet(KEY);
    rKeys.delete(KEY);
  }

  private long getTime() {
    return System.currentTimeMillis();
  }

  public void singIn(int userId) {
    onlineUsers.add(getTime(), String.valueOf(userId));
  }

  public int donateUser() {
    int userId = Integer.parseInt(onlineUsers.pollFirst());
    singIn(userId);
    return userId;
  }

  public void pay(int userId) {
    onlineUsers.add(0, String.valueOf(userId));
    System.out.println("Пользователь № " + donateUser() + " оплатил услугу.");
    System.out.println("На главной странице показываем пользователя № " + userId);
  }
}
