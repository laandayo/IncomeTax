package Repository;

import DataAccess.TaxDAO;

public class TaxRepository implements ITaxRepository{
    @Override
    public double calculateIncome() {
        return TaxDAO.Instance().calculateIncome();
    }
}