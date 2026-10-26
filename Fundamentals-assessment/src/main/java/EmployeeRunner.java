import java.util.Scanner;

/**
 * Project: Fundamentals-assessment
 * Date  : 10/22/2026
 *
 * @author: Phetolo Mokoena
 */
public class EmployeeRunner {
    static void main(String[] args) {
        Sales objSale = new Sales();
        Scanner sc = new Scanner(System.in);

        boolean keeprunning = true;
        while (keeprunning) {
        System.out.println("Please select a menu item below:\n" +
                "1 - See All Sales Personel\n" +
                "2 - Search a SalesPerson\n" +
                "3 - Total Monthly Sales\n" +
                "4 - Monthly Salary\n" +
                "5 - Best Sales Person\n" +
                "6 - Monthly Turnover\n" +
                "7 - Total Salary Expenditure");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                objSale.display();
                break;
            case 2:
                System.out.println("Search for Sales Person");
                String searchN = sc.nextLine();
                int pos = objSale.findSalesPerson(searchN);
                if(pos != -1){
                    System.out.println(searchN + "Is found at index " + pos);
                }else {
                    System.out.println("Sales person does not exist");
                }
                break;
            case 3:
                objSale.calcTotalMonthlySales();
                break;
            case 4:
                objSale.calcMonthlySalary();
                break;
            case 5:
                objSale.getBestSalesPerson();
                break;
            case 6:
                System.out.println("Monthly Turnover: R" + objSale.calcMonthlyTurnOver());
                break;
            case 7:
                System.out.println("Total salary Expenditure: R " + objSale.calcSalaryExpenditure());
                break;
            default:
                System.out.println("Inavlid Option Selected[Please select 1-7]");
        }
            System.out.println("Do you want to continue? [Yes/No]: ");
        String responce = sc.nextLine();
        if (responce.toUpperCase().equals("NO")){
            keeprunning = false;
        }
    }
        System.out.println("Program Terminated\n" +
                "GoodBye");
    }
}
