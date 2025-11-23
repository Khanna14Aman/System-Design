package FlyWeightDesignPattern;

public class AsteroidFlyweight {
    private final int length;
    private final int width;
    private final int weight;
    private final String color;
    private final String texture;
    private final String material;

    public AsteroidFlyweight(int l, int w, int wt, String col, String tex, String mat) {
        this.length = l;
        this.width = w;
        this.weight = wt;
        this.color = col;
        this.texture = tex;
        this.material = mat;
    }

    public void render(int posX, int posY, int velocityX, int velocityY) {
        System.out.println("Rendering " + color + ", " + texture + ", " + material
                + " asteroid at (" + posX + "," + posY
                + ") Size: " + length + "x" + width
                + " Velocity: (" + velocityX + ", "
                + velocityY + ")");
    }

    public static long getMemoryUsage() {
        return Integer.BYTES * 3 +            // length, width, weight
                40 * 3;                       // Approximate string data
    }
}
