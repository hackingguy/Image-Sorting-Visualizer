import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.util.*;
import javax.swing.*;

class ImagePixels{
    Pixel[] imageArray;
    BufferedImage myImg;
    int width,height;
    JFrame jf;
    JLabel background,text;

    ImagePixels(File image){
        jf = new JFrame("Sorting The Image");
        text = new JLabel();
        background = new JLabel();
        try{
            myImg = ImageIO.read(image);
            width = myImg.getWidth();
            height = myImg.getHeight();
            imageArray= new Pixel[myImg.getWidth()*myImg.getHeight()];
        }
        catch(IOException e){
            System.out.println("Image Not Found");
        }
    }

    class Pixel{
        int weight;
        Color color;
    }

    long previousValue;
    void checkProgress(int i,int max){
        Double x=((i*1.0)/max)*100.00;
        if(previousValue<StrictMath.round(x)){
            System.out.println("Sorted: " + StrictMath.round(x) +"%");
            previousValue = StrictMath.round(x);
            text.setText("Sorted :" + StrictMath.round(x) +"%");
        }
    }

    void bubbleSort(){
        int n= width*height;

        for(int i=0;i<n-2;i++){


            for(int j=0;j<n-i-1;j++){
                if(imageArray[j].weight>imageArray[j+1].weight){
                    Pixel temp = imageArray[j];
                    imageArray[j] = imageArray[j+1];
                    imageArray[j+1] = temp;
                }
            }

            updateGUI(i,n-2);
        }
    }

    void merge(int start,int end,int mid){

        int n1=mid-start+1,n2=end-mid,k=start;
        Pixel[] l= new Pixel[n1];
        Pixel[] r= new Pixel[n2];

        for(int i=0;i<n1;i++){
            l[i] = new Pixel();
            l[i] = imageArray[i+start];
        }

        for(int i=0;i<n2;i++){
            r[i] = new Pixel();
            r[i] = imageArray[i+mid+1];
        }

        int i=0,j=0;

        while(i<n1 && j<n2){
            if(l[i].weight<r[j].weight){
                imageArray[k++]=l[i++];
            }
            else  {
                imageArray[k++]=r[j++];
            }
        }

        while(i<n1){
            imageArray[k++]=l[i++];
        }

        while(j<n2){
            imageArray[k++]=r[j++];
        }
    }

    void mergeSort_internal(int start,int end){
        if(start>=end)
            return;

        int mid = (start+end)/2;
        mergeSort_internal(start,mid);
        mergeSort_internal(mid+1,end);
        merge(start,end,mid);
        updateGUI(mid,(width*height));
    }

    void mergeSort(){
        mergeSort_internal(0,width*height-1);
    }

    void updateGUI(int i,int max){  
        BufferedImage update = updateImage();
        ImageIcon img = new ImageIcon(update);
        background.setIcon(img);
        checkProgress(i,max);
    }

    void GUI(){
        jf.setSize(width+200,height+200);
        updateGUI(0,100);
        background.setBounds(100,50,width,height);
        text.setBounds((width-20)/2,100+height,80,20);
        jf.setLayout(null);
        jf.add(background);
        jf.add(text);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    BufferedImage updateImage(){
        BufferedImage newImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        int k=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                newImage.setRGB(j,i,imageArray[k].color.getRGB());
                k++;
            }
        }
        return newImage;
    }

    void randomize(){
        int index;
        Pixel temp;
        Random random = new Random();
        for(int i=(height*width)-1;i>0;i--){
            index = random.nextInt(i+1);
            temp = imageArray[index];
            imageArray[index] = imageArray[i];
            imageArray[i] = temp;
        }
    }

    int count=0;
    void resultImage(){

        BufferedImage newImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        int k=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                newImage.setRGB(j,i,imageArray[k].color.getRGB());
                k++;
            } 
        }
        try{
            ImageIO.write(newImage,"png",new File("C:\\Users\\akash\\Desktop\\SortingImage\\akash-rotate"+(count++)+".png"));
        }
        catch(IOException e){
            System.out.println("Target Location Not Correct");
        }
    }

    void imageProcess(){
        int k=0;
        for(int i=0;i<myImg.getHeight();i++){
            for(int j=0;j<myImg.getWidth();j++){
                imageArray[k]=new Pixel();
                imageArray[k].weight=k;
                imageArray[k].color=new Color(myImg.getRGB(j,i));
                k++;
            } 
        }

    } 

    public static void main(String[] args){
        File image = new File("C:\\Users\\akash\\Desktop\\SortingImage\\akash.jpg");
        ImagePixels img = new ImagePixels(image);
        img.imageProcess();
        img.randomize();
        img.GUI();
        img.resultImage();
        img.mergeSort();
        //img.bubbleSort();
        img.resultImage();
    }
}