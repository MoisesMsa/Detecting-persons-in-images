package sample;

public class Target implements Comparable<Target>{

    public Target(int index, float distance, String target){
        this.id = index;
        this.val = distance;
        this.target = target;
    }
    public Float getVal() {
        return val;
    }

    public int getId() {
        return id;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public int compareTo(Target t) {
        return this.getVal().compareTo(t.getVal());
    }

    private
        Float val;
        String target;
        int id;
}