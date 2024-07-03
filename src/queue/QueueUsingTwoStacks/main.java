package queue.QueueUsingTwoStacks;

public class main {

    public static void main(String[] args) {
        Queue first = new Queue();

        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);
        first.add(5);

        System.out.println(first.remove());
        System.out.println(first.remove());
        System.out.println(first.remove());

        first.add(6);
        first.isEmpty();

        System.out.println(first.remove());
        System.out.println(first.remove());
        System.out.println(first.remove());

        System.out.println(first.isEmpty());

    }
}
