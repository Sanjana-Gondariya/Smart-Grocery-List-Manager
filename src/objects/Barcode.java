package objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Barcode {
    private double cost;
    private BufferedImage barcode;

    public Barcode() {
        this.cost = 0.0;
        this.barcode = null;
    }

    /**
     * @param imagePath path to the image file
     * @throws IOException if image cannot be read
     */
    public void loadBarcode(String imagePath) throws IOException {
        File barcodeFile = new File(imagePath);
        if (!barcodeFile.exists()) {
            throw new IOException("File not found: " + imagePath);
        }

        this.barcode = ImageIO.read(barcodeFile);
        if (this.barcode == null) {
            throw new IOException("Invalid image or failed to load: " + imagePath);
        }
    }

    /**
     * Extracts cost from barcode (stub - requires ZXing library via Maven).
     * @return extracted cost as a double
     */
    public double extractCost() {
        if (this.barcode == null) {
            System.err.println("No barcode loaded. Call loadBarcode() first.");
            return 0.0;
        }

        // Stub: ZXing decoding requires Maven dependency
        System.out.println("Barcode decoding not yet implemented (requires ZXing library).");
        return 0.0;
    }

    /**
     * Updates the cost field.
     * @param newCost the new cost to set
     */
    public void updateCost(double newCost) {
        this.cost = newCost;
    }

    /**
     * Returns the cost value.
     * @return cost as a double
     */
    public double getCost() {
        return this.cost;
    }
}

