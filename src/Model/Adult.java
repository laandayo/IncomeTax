package Model;


public class Adult {
    private int age;
    private String gender;



    public Adult(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Adult{" + "age=" + age + '}';
    }


}