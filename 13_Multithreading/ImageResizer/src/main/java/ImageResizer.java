import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageResizer extends Thread {

  private File[] files;
  private int newWidth;
  private String newPictures;
  private long start;

  public ImageResizer(File[] files, int newWidth, String newPictures, long start) {
    this.files = files;
    this.newWidth = newWidth;
    this.newPictures = newPictures;
    this.start = start;
  }

  @Override
  public void run() {
    try {
      for (File file : files) {
        BufferedImage image = ImageIO.read(file);
        if (image == null) {
          continue;
        }

        int newHeight = (int) Math.round(
            image.getHeight() / (image.getWidth() / (double) newWidth)
        );
        image = Scalr
            .resize(image, Method.ULTRA_QUALITY, Mode.AUTOMATIC, newWidth, newHeight);

        File newFile = new File(newPictures + "/" + file.getName());
        ImageIO.write(image, "jpg", newFile);
        image.flush();

      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Duration: " + (System.currentTimeMillis() - start + " ms"));
  }
}
