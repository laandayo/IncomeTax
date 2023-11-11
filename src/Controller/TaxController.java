package Controller;
import Repository.TaxRepository;
import View.Menu;

public class TaxController extends Menu {
    private final TaxRepository taxrepo;
    static String[] options = {"Proceed to calculate tax","Exit"};

    public TaxController() {
        super("\n========== Tax Calculating Program =========", options);
        taxrepo = new TaxRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice) {
            case 1:
                System.out.print("Tax income: " + taxrepo.calculateIncome() + " VNĐ");
                break;
            case 2:
                System.out.println("Exit.");
                break;
            default:
                System.out.println("Invalid!");
        }
    }
}
