package objects;

public class Budget{
    public double budget;
    public double moneySpent;

    public Budget(double budget) {
        this.budget = budget;
        this.moneySpent = 0;
    }

    public void updateBudget(double budgetToSet){
        this.budget = budgetToSet;
    }

    public double getBudget(){
        return this.budget;
    }

    public void updateMoneySpent(double amount){
        this.moneySpent += amount;
    }

}
