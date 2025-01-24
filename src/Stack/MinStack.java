package Stack;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Long> list;
    long min;

    public MinStack() {
        this.list = new ArrayList<>();
        this.min = Long.MAX_VALUE;
    }

    public void push(int v) {
        long val = (long)v;
        if(this.list.size() == 0){
            this.list.add(val);
            this.min = val;
        }
        else{
            if(this.min < val) this.list.add(val);
            else{
                this.list.add(2*val - this.min);
                this.min = val;
            }
        }
    }

    public void pop() {
        if(this.list.size() == 0) return;
        if(this.min > this.list.get(this.list.size()-1)){
            this.min = 2*this.min - this.list.remove(this.list.size()-1);
        }
        else this.list.remove(this.list.size()-1);
    }

    public int top() {
        if(this.list.size() == 0) return -1;

        if(this.min > this.list.get(this.list.size()-1)){
            return (int)min;
        }
        else return (int)(long) this.list.get(this.list.size()-1);
    }

    public int getMin() {
        return (int)this.min;
    }


    public static void main(String[] args) {

    }
}
