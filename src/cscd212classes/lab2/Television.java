package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make)throws IllegalArgumentException{
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;

       if(resolution == 2160){
            this.fourK = true;
        }
        else{
            this.fourK = false;
        }
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){
       this(model,smart,screenSize,resolution,make);
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Television)) {
            return false;
        }
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && make.equals(that.make) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return String.valueOf(this.make).hashCode() + String.valueOf(this.model).hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    @Override
    public String toString() {
        String tv = this.make + "-" + this.model + ", " + this.screenSize + " inch";
        if(this.smart == true){
          tv =  tv + " smart";
        }
        tv = tv + " tv";

        if(this.fourK == true){
            tv = tv + " with 4K resolution";
        }
        else{
            tv = tv + " with " + resolution + " resolution";
        }
        return tv;
    }


    @Override
    public int compareTo(Television another) {
        if(another == null){
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        if(this.getMake().compareTo(another.getMake()) == 0){
            if(this.getModel().compareTo(another.getModel()) == 0){
                if(this.getScreenSize() - another.getScreenSize() == 0){
                    return 0;
                }
                return this.getScreenSize()-another.getScreenSize();
            }
            return this.getModel().compareTo(another.getModel());
        }
        return this.getMake().compareTo(another.getMake());
    }
}
