import java.io.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class DriverGUI extends SortImage{

    JFrame jframe;
    JLabel heading,background;
    JButton b1,b2,b3,b4,b5;

    //GUI Driver Randomizer
    class RandomizeImage implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.out.println(width+""+height);
            randomize();
            BufferedImage update = resultImage();
            ImageIcon img = new ImageIcon(update);
            background.setIcon(img);
        }
    }

    DriverGUI(File image){
        super(image);
        background = new JLabel();
        jframe = new JFrame("Sorting Algos");
        heading = new JLabel("Select Any Algo:");
        b1 = new JButton("Insertion Sort");
        b2 = new JButton("Bubble Sort");
        b3 = new JButton("Selection Sort");
        b4 = new JButton("Merge Sort");
        b5 = new JButton("Randomize Image");
    }

    void GuiDriver(Pixel[] imageArray,int width,int height){
        jframe.setSize(width+200,height+200);
        jframe.setLayout(null);
        background.setBounds(100,20,width,height);
        heading.setBounds(100,height+40,width/3,20);
        b1.setBounds(100,height+80,width/3,20);
        b2.setBounds(100+((2*width)/3),height+80,width/3,20);
        b3.setBounds(100,height+120,width/3,20);
        b4.setBounds(100+((2*width)/3),height+120,width/3,20);
        b5.setBounds(100+(width)/3,height+100,width/3,20);
        BufferedImage update = resultImage();
        ImageIcon img = new ImageIcon(update);
        background.setIcon(img);
        b1.addActionListener(new InsertionSortListener(imageArray,width,height));
        b2.addActionListener(new BubbleSortListener(imageArray,width,height));
        b3.addActionListener(new SelectionSortListener(imageArray,width,height));
        b4.addActionListener(new MergeSortListener(imageArray,width,height));
        b5.addActionListener(new RandomizeImage());
        jframe.add(background);
        jframe.add(heading);
        jframe.add(b1);
        jframe.add(b2);
        jframe.add(b3);
        jframe.add(b4);
        jframe.add(b5);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        System.out.print("Enter Path Of Image:");
        Scanner sc = new Scanner(System.in);
        File image = new File(sc.nextLine());
        sc.close();
        DriverGUI img = new DriverGUI(image);
        Pixel[] imageArray=img.imageProcess();
        int width = img.getWidth();
        int height = img.getHeight();
        img.GuiDriver(imageArray,width,height);
    }
}