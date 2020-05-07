import java.awt.image.*;
import javax.swing.*;


abstract class GUI{
    
    JFrame jf;
    JLabel background,text;
    Pixel[] imageArray;
    int width,height;
    
    GUI(Pixel[] imageArray,int width,int height){
        jf = new JFrame("Sorting The Image");
        text = new JLabel();
        background = new JLabel();
        this.width=width;
        this.height=height;
        this.imageArray = imageArray;
        makeGui();
    }
    
    void makeGui(){
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
    
    long previousValue;
    void checkProgress(int i,int max){
        Double x=((i*1.0)/max)*100.00;
        if(previousValue<StrictMath.round(x)){
            System.out.println("Sorted: " + StrictMath.round(x) +"%");
            previousValue = StrictMath.round(x);
            text.setText("Sorted :" + StrictMath.round(x) +"%");
        }
    }
    
    void updateGUI(int i,int max){  
        BufferedImage update = updateImage();
        ImageIcon img = new ImageIcon(update);
        background.setIcon(img);
        checkProgress(i,max);
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
    
}