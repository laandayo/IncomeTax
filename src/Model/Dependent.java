package Model;

import java.util.ArrayList;


public class Dependent {
    private double income;
    private ArrayList<Child> child;
    private ArrayList<Adult> adult;

    public Dependent(double income, ArrayList<Child> child, ArrayList<Adult> adult) {
        this.income = income;
        this.child = child;
        this.adult = adult;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public ArrayList<Child> getChild() {
        return child;
    }

    public void setChild(ArrayList<Child> child) {
        this.child = child;
    }

    public ArrayList<Adult> getAdult() {
        return adult;
    }

    public void setAdult(ArrayList<Adult> parent) {
        this.adult = adult;
    }

    @Override
    public String toString() {
        return "Dependent{" + "income=" + income + ", child=" + child + ", adult=" + adult + '}';
    }
}