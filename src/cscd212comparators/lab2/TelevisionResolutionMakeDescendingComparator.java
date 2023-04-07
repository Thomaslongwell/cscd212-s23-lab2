package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator {

    public int compare(Television t1, Television t2){
        if(t1 == null || t2 == null) {
            throw new IllegalArgumentException("Invalid Object");
        }

        if(t1.getResolution() - t2.getResolution() == 0){
            if(t1.getMake().compareTo(t2.getMake()) == 0){
                return 0;
            }
            return (t1.getMake().compareTo(t2.getMake()));
        }
        return (t1.getResolution() - t2.getResolution());
    }

}
