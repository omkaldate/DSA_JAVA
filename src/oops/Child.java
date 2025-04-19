package oops;

public class Child extends Parent {
    int b;

    public void sum() throws UserNotFound {
        try {
            System.out.println("int the child class");
            throw new UserNotFound("User not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
