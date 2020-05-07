import java.awt.event.*;
import java.awt.*;

class InsertionSortListener implements ActionListener {
    Pixel[] imageArray;
    int width,height;
    
    InsertionSortListener(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
    }
    public void actionPerformed(ActionEvent e){
        Thread insertionSort = new Thread(new InsertionSortThread(imageArray,width,height));
        insertionSort.start();
    }
}

class InsertionSortThread implements Runnable {
    Pixel[] imageArray;
    int width,height;
    
    InsertionSortThread(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        
    }
    
    public void run(){
        InsertionSort sort = new InsertionSort(imageArray,width,height);
    }
}


