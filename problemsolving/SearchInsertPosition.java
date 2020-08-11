package problemsolving;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int arr[]={2,4,6,8,10,12};
        int val=5;
        int left=0;
        int high=arr.length-1;
        if(val<=arr[left])
            System.out.println(left);
        else if(val>=arr[high])
            System.out.println(high);
        else
        while(left<=high){
            int mid=left+(high-left)/2;
            if(arr[mid]==val) {
                System.out.println(mid);
                break;
            }else if(arr[mid]<val){
                    left=mid+1;
            }else {
                    high=mid-1;
            }
        }
        System.out.println(left);

    }
}
