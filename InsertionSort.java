class InsertionSort extends GUI implements Sort {
    Pixel[] imageArray;
    int width,height;
    
    InsertionSort(Pixel[] imageArray,int width,int height){
        super(imageArray,width,height);
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        Sort();
    }
    
    public void Sort(){
        int n=width*height;
        int j;
        for(int i=1;i<n;i++){
            j=i;
            while(j>0 && imageArray[j].weight<imageArray[j-1].weight){
                Pixel temp = imageArray[j];
                imageArray[j] = imageArray[j-1];
                imageArray[j-1] = temp;
                j--;
            }
            updateGUI(i,n);
        }
    }
}