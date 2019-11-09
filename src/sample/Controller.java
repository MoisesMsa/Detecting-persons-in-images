package sample;

import java.util.*;

public class Controller {

    public Controller(String path){
            this.img = new Image(path);
    }

    public void KNN(List<float> dataset, List<float> img){
        for (List<float> dataset : d) {
            this.chebychevDistance(d, img);
        }

        //rank -> sort
        //select
        //get often target
        //target
    }

    public float chebychevDistance(List<Float> img_d, List<Float> img){
        List<Float> diffContainer = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
            diffContainer.add(img_d.get(i) - img.get(i));

        return Collections.max(diffContainer);
    }

    private
        Dataset dataset = new Dataset();
        Image img;
}
