import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Barcode {
    private double cost;
    private BufferedImage barcode;

    public Barcode() {
        this.barcode = null;
        this.cost = 0.0;
    }

    public void loadBarcode(String imagePath) throws IOException {
        File file = new File(imagePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + imagePath);
        }
        this.barcode = ImageIO.read(file);
        if (this.barcode == null) {
            throw new IOException("Failed to load image from: " + imagePath);
        }
    }

    // Stub extractor: ZXing not included. Returns 0.0 and logs a message.
    private double extractCost() {
        System.err.println("Barcode decoding not available: ZXing dependency not present. Returning 0.0");
        return 0.0;
    }

    public void updateCost() {
        this.cost = extractCost();
    }

    public double getCost() {
        return this.cost;
    }

    public static void main(String[] args) {
        Barcode barcode = new Barcode();
        if (args.length == 0) {
            System.out.println("Usage: java Barcode <path-to-image>");
            return;
        }
        try {
            barcode.loadBarcode(args[0]);
            barcode.updateCost();
            System.out.println("Extracted Cost: $" + barcode.getCost());
        } catch (IOException e) {
            System.err.println("Error reading barcode: " + e.getMessage());
        }
    }
}
