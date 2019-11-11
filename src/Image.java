/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image{

    public int size;
    private String path;
    public int[] pixels;

    public static Image tiles = new Image(576, "/textures/sheets/SpriteSheet.png");

    public Image(int size, String path) {
        this.size=size;
        this.path=path;
        pixels=new int[size*size];
        load();
    }
    void load(){
        try{
            BufferedImage image = ImageIO.read(Image.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/