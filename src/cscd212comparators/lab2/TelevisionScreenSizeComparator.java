package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

public class TelevisionScreenSizeComparator {

    public int compare(Television t1, Television t2){
        if(t1 == null || t2 == null){
            throw new IllegalArgumentException("Invalid Object");
        }
        return (t1.getScreenSize() - t2.getScreenSize());
    }
}