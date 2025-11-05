import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Barcode {
    public double cost;
    public BufferedImage barcode;

    public Barcode() {
        this.barcode = null;
        this.cost = 0.0;
    }

    public void scanBarcode() {
        File barcodeImage = new File("path");
        this.barcode = ImageIO.read(barcodeImage);
    }

    private double extractCost() {
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(this.barcode);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        MultiFormatReader reader = new MultiFormatReader();
        Result result = reader.decode(bitmap);

        System.out.println("Barcode Text: " + result.getText());

        double costFromReceipt = 0;
        return costFromReceipt;
    }

    public void updateCost(double update) {
        this.cost = extractCost();
    }

    public double getCost() {
        return this.cost;
    }
}