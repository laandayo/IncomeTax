package DataAccess;

import Common.Validation;
import java.util.ArrayList;
import Model.Child;
import Model.Dependent;
import Model.Adult;

public class TaxDAO {
    private static TaxDAO instance = null;

    public TaxDAO() {
    }

    public static TaxDAO Instance() {
        if (instance == null) {
            synchronized (TaxDAO.class) {
                if (instance == null) {
                    instance = new TaxDAO();
                }
            }
        }
        return instance;
    }
    ArrayList<Child> cList = new ArrayList<>();
    ArrayList<Adult> aList = new ArrayList<>();

    public Dependent inputDependent() {

        System.out.print("Insert income:  ");
        double income = Validation.getDouble();
        System.out.print("Insert number of children: ");
        int numChildren = Validation.getInt();

        for (int i = 0; i < numChildren; i++) {
            System.out.print("Please insert the number " + (i+1) + " child's age: ");
            int age = Validation.getInt();
            System.out.print("Are your children studying? (Y/N): ");
            boolean n = Validation.checkYN();
            Child c = new Child(age, n);
            cList.add(c);
        }

        System.out.print("Insert number of adults: ");
        int numAdult = Validation.getParentInt();

        for (int i = 0; i < numAdult; i++) {
            System.out.print("Please insert the number " + (i+1) + " adult's age: ");
            int age = Validation.getInt();
            System.out.print("Please insert the gender of " + (i+1) + " adult (M/F): ");
            String gender = Validation.validateGenderInput();
            Adult p = new Adult(age, gender);
            aList.add(p);
        }
        return new Dependent(income, cList, aList);
    }

    public double deductionChild(ArrayList<Child> children) {
        int countAbove18S = 0;
        int countAbove18NS = 0;
        for (Child child : children) {
            if (child.getAge() < 18) {
            } else if (child.getAge() >= 18 && child.getStatus()) {
                countAbove18S++;
            } else {
                countAbove18NS++;
            }
        }
        if (children.size() == 1) {
            if (children.get(0).getAge() < 18) {
                return 4400000;
            } else {
                if (children.get(0).getStatus()) {
                    return 6000000;
                } else {
                    return 0;
                }
            }
        } else if (children.size() == 2) {
            if (countAbove18NS == 2) {
                return 0;
            } else if (countAbove18NS == 1 && countAbove18S == 1) {
                return 6000000;
            } else if (countAbove18S == 2) {
                return 12000000;
            }
        } else {
            return 0;
        }
        return 0;
    }

    public double deductionAdult(ArrayList<Adult> adult) {
        int countG = 0;
        int count = 0;
        for (Adult value : adult) {
            if (value.getAge() < 60) {
                count++;
            }
            if ((value.getGender().equals(String.valueOf('F')))&&(value.getAge() >= 55)) {
                countG++;
            }
        }
        count = count * 4400000 + countG * 4000000;
        return count;
    }

    public double calculateIncome() {
        Dependent d = inputDependent();
        double income = d.getIncome();
        double incomeExempt;

        double deductionAdult = deductionAdult(d.getAdult());
        double deductionChild = deductionChild(d.getChild());

        if (income > 11000000) {
            incomeExempt = income - 11000000 - deductionAdult - deductionChild;
            if (incomeExempt < 4000000) {
                return 0;
            } else if (incomeExempt >= 4000000 && incomeExempt < 6000000) {
                return incomeExempt * 0.05;
            } else if (incomeExempt >= 6000000 && incomeExempt < 10000000) {
                return incomeExempt * 0.1;
            } else {
                return incomeExempt * 0.2;
            }
        } else {
            return 0;
        }
    }
}