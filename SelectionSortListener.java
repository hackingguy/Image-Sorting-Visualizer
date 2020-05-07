import java.awt.event.*;

class SelectionSortListener implements ActionListener {
    Pixel[] imageArray;
    int width,height;
    
    SelectionSortListener(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
    }
    public void actionPerformed(ActionEvent e){
        Thread selectionSort = new Thread(new SelectionSortThread(imageArray,width,height));
        selectionSort.start();
    }
}

class SelectionSortThread implements Runnable {
    Pixel[] imageArray;
    int width,height;
    
    SelectionSortThread(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        
    }
    
    public void run(){
        SelectionSort sort = new SelectionSort(imageArray,width,height);
    }
}