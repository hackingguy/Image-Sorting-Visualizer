import java.awt.event.*;

class MergeSortListener implements ActionListener {
    Pixel[] imageArray;
    int width,height;
    
    MergeSortListener(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
    }
    public void actionPerformed(ActionEvent e){
        Thread mergeSort = new Thread(new MergeThread(imageArray,width,height));
        mergeSort.start();
    }
}

class MergeThread implements Runnable {
    Pixel[] imageArray;
    int width,height;
    
    MergeThread(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        
    }
    
    public void run(){
        MergeSort sort = new MergeSort(imageArray,width,height);
    }
}


