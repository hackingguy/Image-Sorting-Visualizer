class MergeSort extends GUI implements Sort{
    Pixel[] imageArray;
    int width,height;
    
    MergeSort(Pixel[] imageArray,int width,int height){
        super(imageArray,width,height);
        this.imageArray = imageArray;
        this.width = width;
        this.height = height;
        Sort();
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

    public void Sort(){
        mergeSort_internal(0,width*height-1);
    }
}