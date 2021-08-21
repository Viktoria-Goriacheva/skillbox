public class RedisTest {

  private static final int NUMBER_OF_USERS = 20;
  private static final int MIN_NUMBER_OF_USERS = 1;
  private static final int MAX_NUMBER_OF_USERS = 20;
  private static final int PAID_USER = 10;

  public static void main(String[] args) throws InterruptedException {
    RedisStorage storage = new RedisStorage();
    storage.init();

    for (int i = 1; i <= NUMBER_OF_USERS; i++) {
      storage.singIn(i);
      Thread.sleep(200);
    }

    while (true) {
      if ((int) (Math.random() * PAID_USER) == 1) {
        storage.pay((int) (Math.random() * (MAX_NUMBER_OF_USERS - MIN_NUMBER_OF_USERS))
            + MIN_NUMBER_OF_USERS);
      }
      System.out.println("На главной странице показываем пользователя № " + storage.donateUser());
      Thread.sleep(1000);
    }
  }
}
