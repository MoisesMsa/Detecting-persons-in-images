package controller;

import model.Target;

import java.util.*;

public class Controller {


    public Boolean knn(List<String[]> dataset, List<Float> img, int k) {

        List<Target> targerts = new ArrayList();

        int index = 0;
        for (String[] d : dataset) {
            Float distance = this.chebychevDist(d, img);
            targerts.add(new Target(index, distance, d[1000]));
            index++;
        }

        Collections.sort(targerts);
//        for (Target t: targerts) {
//            System.out.println(">>>>>>>>>>>>>>> distance order: " + t.getVal() + " " + t.getTarget() );
//        }
            List<Target> neighbors = targerts.subList(0, k);

        return checkTarget(neighbors);
    }


    public Boolean checkTarget(  List<Target> targerts) {

        int hasPerson = 0, noPerson = 0;

        for (Target t: targerts) {
//            System.out.println("::::::::::: "+ t);

            if(t.getTarget().equals("person")){
                hasPerson++;
            }else if(t.getTarget().equals("noPerson")){
                noPerson++;
            }
        }
//        System.out.println("has: "+ hasPerson);
//        System.out.println("NO has: "+ noPerson);

        return hasPerson > noPerson ?  true : false;
    }

    public Float chebychevDist(String[] img_d, List<Float> img){

        List<Float> diffContainer = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
            diffContainer.add(Float.parseFloat(img_d[i]) - img.get(i));

        return Collections.max(diffContainer);
    }

}
