package cscd212classes.lab2;

import java.util.Objects;

public class Television extends Object implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make)throws IllegalArgumentException{
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException("Invalid Parameters");
        }

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution)throws IllegalArgumentException{
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException("Invalid Parameters");
        }

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
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
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && make.equals(that.make) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fourK, make, model, resolution, screenSize, smart);
    }

    @Override
    public String toString() {
        String tv = this.make + this.model + this.screenSize;
        if(getResolution() == 2160)
            this.fourK = true;

        return tv;
    }


    @Override
    public int compareTo(Television another) {
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