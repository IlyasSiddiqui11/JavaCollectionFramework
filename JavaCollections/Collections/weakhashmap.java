import java.util.Map;
import java.util.WeakHashMap;

public class weakhashmap {
    public static void main(String[] args) {
        WeakHashMap<String,Image> imageCache = new WeakHashMap<>();
        // imageCache.put("img1", new Image("Image1"));
        // imageCache.put("img2", new Image("Image2"));
        //                  ||
        // If we store the above as String directly it is a "StrongReference" as it is stored in String pool.
        // Instead we can pass an String object directly for the key.
        // 
        // The below function does nothing but -> imageCache.put(new String("img1"), new Image("Image1"));
        loadCache(imageCache);
        System.out.println(imageCache);
        simulateRunningShits();
        System.gc();// We won't call this method in real projects.
        System.out.println("Some images might get deleted from the heap: " + imageCache);

    }
    public static void loadCache(Map<String,Image> imgCache){
        String key1 = new String("img1");
        String key2 = new String("img2");
        imgCache.put(key1, new Image("Image1"));
        imgCache.put(key2, new Image("Image2"));
        
    }
    public static void simulateRunningShits(){
    try {
        System.out.println("Simulating runnig application....");
        Thread.sleep(5000);
    } catch (Exception e) {
        
    }
}
}
class Image{
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    
}