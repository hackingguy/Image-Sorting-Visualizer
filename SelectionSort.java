class SelectionSort extends GUI implements Sort{
    Pixel[] imageArray;
    int width,height;
    
    SelectionSort(Pixel[] imageArray,int width,int height){
        super(imageArray,width,height);
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        Sort();
    }
    
    public void Sort(){
        int n= width*height;
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n-1;j++){
                if(imageArray[j].weight<imageArray[i].weight){
                    Pixel temp = imageArray[i];
                    imageArray[i] = imageArray[j];
                    imageArray[j] = temp;
                }
            }
            updateGUI(i,n);
        }
    }
    
}