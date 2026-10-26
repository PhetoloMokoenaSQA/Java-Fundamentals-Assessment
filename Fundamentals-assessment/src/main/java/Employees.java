/**
 * Project: Fundamentals-assessment
 * Date  : 10/22/2026
 *
 * @author: Phetolo Mokoena
 */
public class Employees {
    private String name;
    private final double basicwage = 7500.00;
    private double finalSalary;
    private double sales ;

    public Employees(String name, double sales, double finalSalary) {
        this.name = name;
        this.sales = sales;
        this.finalSalary = finalSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public double getBasicwage() {
        return basicwage;
    }
    public double getCommision(){
        return sales * 0.10;
    }
}
