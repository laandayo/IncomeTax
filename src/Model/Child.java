package Model;


public class Child {
    private int age;
    private boolean status;

    public Child(int age, boolean status) {
        this.age = age;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}