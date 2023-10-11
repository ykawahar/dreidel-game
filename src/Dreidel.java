import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class Dreidel {
    private Random random;
    private List <String> faces = List.of("Nun", "Gimel", "Hei", "Shin");

    public String spinDreidel(){
        Random rand = new Random();
        return faces.get(rand.nextInt(4));
    }





}
