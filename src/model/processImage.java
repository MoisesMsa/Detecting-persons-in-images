package model;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;
import org.opencv.imgcodecs.Imgcodecs;

public class processImage {
    private
        List<Float> features;
        String name, path;

    public processImage(String path) {
        this.path = path;

        Imgcodecs imageCodecs = new Imgcodecs();
        Mat img = imageCodecs.imread(this.path, Imgcodecs.IMREAD_GRAYSCALE);
        Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);

        MatOfFloat features = new MatOfFloat();
        HOGDescriptor hog = new HOGDescriptor();
        hog.compute(img,features);

        this.features = features.toList();
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return path;
    }

    public List<Float> getFeatures() {
        return features;
    }
}
