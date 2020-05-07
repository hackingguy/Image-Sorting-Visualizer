import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.util.*;

class SortImage {
    Pixel[] imageArray;
    BufferedImage myImg;
    int width,height;

    SortImage(File image){
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

    int getWidth(){
        return width;
    }

    int getHeight(){
        return height;
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
    BufferedImage resultImage(){

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

    Pixel[] imageProcess(){
        int k=0;
        for(int i=0;i<myImg.getHeight();i++){
            for(int j=0;j<myImg.getWidth();j++){
                imageArray[k]=new Pixel();
                imageArray[k].weight=k;
                imageArray[k].color=new Color(myImg.getRGB(j,i));
                k++;
            } 
        }

        return imageArray;
    } 
}