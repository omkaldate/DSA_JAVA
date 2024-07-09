package queue;

public class CircularTour {
    public static int tour(int pet[], int dis[]){
        int difict=0;
        int balance =0;
        int start =0;

        for(int i=0; i<pet.length; i++){
            balance += pet[i]-dis[i];
            if(balance < 0){
                difict += balance;
                start = i+1;
                balance = 0;
            }
        }
        if(difict + balance >= 0){
            return start;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int []pet = {4,6,7,4};
        int[]dist = {6,5,3,5};
        System.out.println(tour(pet,dist));
    }
}
