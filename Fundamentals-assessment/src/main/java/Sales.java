import java.util.Scanner;

/**
 * Project: Fundamentals-assessment
 * Date  : 10/22/2026
 *
 * @author: Phetolo Mokoena
 */
public class Sales {
    String [] arPersons;
    double[][] arSales;
    Scanner sc1 = new Scanner(System.in);

    public Sales() {
     arPersons = new String[4];
     arSales = new double[4][4];

     Initialize();
    }
    /**
     * Intializes the Arrays
     */
    public void Initialize(){
        arPersons[0] = "Peter";
        arSales[0] = new double[]{1500.00, 12000.00, 3000.00, 2845.00};
          arPersons[1] = "Thabang";
        arSales[1] = new double[]{1000.00, 2000.00, 2000.00, 11400.00};
          arPersons[2] = "Jessica";
        arSales[2] = new double[]{500.00, 2000.00, 13000.00, 800.00};
          arPersons[3] = "Lethabo";
        arSales[3] = new double[]{1550.00, 1000.00, 4000.00, 13500.00};
    }

    /**
     * Finds the SalesPerson Using their name
     * @param name Name
     * @return SalesPerson
     */
    public int findSalesPerson(String name){
        for(int x = 0 ; x < arPersons.length; x++){
            if(arPersons[x].equalsIgnoreCase(name)){
                return x;
            }
        }
        return -1;
    }
    /**
     * Calculates the Total Monthly sales of a SalesPerson
     * @return Sales for the Month
     */
    public double calcTotalMonthlySales(){
        System.out.println("Please enter name of the SalesPerson: ");
        String name = sc1.nextLine();
        int pos = findSalesPerson(name);
        if (pos == -1) {
            System.out.println("SalesPerson "+name + " Does not exist");
            return 0.0;
        }
        double total = getTotalSales(pos);
        for (double sale : arSales[pos]){
            total += sale;
        }
       // Employees empl = new Employees(name, total, 0);
        System.out.println("Total Monthly Sales for " + name + "   " + total);
        //return empl.getBasicwage() + empl.getCommision();
        return total;
    }

    /**
     *
     * @param index
     * @return
     */
    public double getTotalSales(int index){
        double total = 0;
        for(double sale : arSales[index]){
            total += sale ;
        }
        return total;
    }

    /**
     * Calculates the monthly salary of a SalesPerson
     */
    public void calcMonthlySalary(){
        System.out.println("Please enter name of the SalesPerson: ");
        String name = sc1.nextLine();
        int pos = findSalesPerson(name);
        if(pos == -1) {
            System.out.println("Sales Person "+ name + " Does not Exist" );
            //return 0.0;
        }
        double totalSales = getTotalSales(pos);
        Employees emp = new Employees(name , totalSales, 0);
        double salary = emp.getBasicwage() + emp.getCommision();
        System.out.println("Monthly Salary for "+name + ": " + salary );
        //return salary;
    }

    /**
     * Calculates the TurnOver/Profit of the Furniture Store
     * @return Profit
     */
    public double calcMonthlyTurnOver(){
        double totalTurn = 0;
        for (int i = 0 ; i < arPersons.length; i++ ){
            totalTurn += getTotalSales(i);
        }
        return totalTurn;
    }

    /**
     * Calculates the Total Money Spent on distributing salaries
     * @return Total Salaries Paid
     */
    public double calcSalaryExpenditure(){
        double totalsSalary = 0;
        for (int x = 0; x < arPersons.length; x++){
            totalsSalary += getTotalSales(x);
        }
        return totalsSalary;
    }

    /**
     * Finds The best SalesPerson
     */
    public void getBestSalesPerson() {
        int best = 0;
        double highest = getTotalSales(0);

        for (int i = 0; i < arPersons.length; i++) {
            double currentSale = getTotalSales(i);
            if (currentSale > highest) {
                highest = currentSale;
                best = i;
            }
        }
        String winner = arPersons[best];
        double highesSalary = getTotalSales(best);
        Employees bestEmp = new Employees(winner, highest, highesSalary);

        System.out.println( "--- best sales Person of the Month is: \n" +
        bestEmp.getName() + "       " + bestEmp.getSales());

    }
    public void display(){
        System.out.println("\n--- All SalesPeople ---");
        System.out.println("Name\t\tWeek 1\t\tWeek 2\t\tWeek 3\t\tWeek 4\t\tTotal Monthly");
        System.out.println("============================================================");

        for (int x = 0; x < arPersons.length; x++){
            double total = getTotalSales(x);
            System.out.println(arPersons[x] + "\t\t" +
                            "R" + arSales[x][0]+ "\t\t" +
                            "R" + arSales[x][1]+ "\t\t" +
                            "R" + arSales[x][2]+ "\t\t" +
                            "R" + arSales[x][3]+ "\t\t" +
                            "R" + total);
        }

    }
    public String getEmployeeName(int index){
        return arPersons[index];
    }
}
