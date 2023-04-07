package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator {

    public int compare(Television t1, Television t2){
        if(t1 == null || t2 == null) {
            throw new IllegalArgumentException("Invalid Object");
        }

       if (t1.getModel().compareTo(t2.getModel()) == 0){
           if(t1.getScreenSize() - t2.getScreenSize() == 0){
               return 0;
           }
           return (t1.getScreenSize() - t2.getScreenSize());
       }
       return(t1.getModel().compareTo(t2.getModel()));
    }

}