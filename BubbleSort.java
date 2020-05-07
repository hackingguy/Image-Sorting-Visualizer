class BubbleSort extends GUI implements Sort{
    Pixel[] imageArray;
    int width,height;
    
    BubbleSort(Pixel[] imageArray,int width,int height){
        super(imageArray,width,height);
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        Sort();
    }
    
    
    public void Sort(){
        int n= width*height;
        int percent=0;

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
}