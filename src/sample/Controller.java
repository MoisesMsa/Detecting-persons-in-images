package sample;

import java.util.*;

public class Controller {

    public Boolean knn(List<String[]> dataset, List<Float> img){

        List<String> targerts = new ArrayList();

        for (String[] d : dataset) {
            Float distance = this.chebychevDist(d, img);
            if(distance <= 1) targerts.add(d[1000]);
        }

        return checkTarget(targerts);
    }


    public Boolean checkTarget( List<String> targerts){

        int hasPerson = 0, noPerson = 0;

        for (String t: targerts) {
            if(t == "Person"){
                hasPerson++;
            }else if(t == "No Person"){
                noPerson++;
            }
        }

        return hasPerson > noPerson ?  true : false;
    }

    public Float chebychevDist(String[] img_d, List<Float> img){
        List<Float> diffContainer = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
            diffContainer.add(Float.parseFloat(img_d[i]) - img.get(i));

        return Collections.max(diffContainer);
    }

}
