import java.awt.event.*;

class BubbleSortListener implements ActionListener {
    Pixel[] imageArray;
    int width,height;
    
    BubbleSortListener(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
    }
    public void actionPerformed(ActionEvent e){
        Thread bubbleSort = new Thread(new BubbleThread(imageArray,width,height));
        bubbleSort.start();
    }
}


class BubbleThread implements Runnable {
    Pixel[] imageArray;
    int width,height;
    
    BubbleThread(Pixel[] imageArray,int width,int height){
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        
    }
    
    public void run(){
        BubbleSort sort = new BubbleSort(imageArray,width,height);
    }
}
