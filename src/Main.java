import java.util.ArrayList;

abstract class employee{
    private String EmployeeName;
    private int EmployeeID;
    public employee(String EmployeeName, int EmployeeID){
        this.EmployeeName=EmployeeName;
        this.EmployeeID=EmployeeID;
    }
    public String getEmployeeName(){
        return EmployeeName;
    }
    public int getEmployeeID(){
        return EmployeeID;
    }
    public abstract double CalculationOfSalary();


    public String toString(){
       return "Employee[Name= "+ EmployeeName + ", ID= "+ EmployeeID+ ", Salary= "+CalculationOfSalary()+"]";
   }
}
class FullTimeEmployee extends employee{
    private  double MonthlySalary;
     public FullTimeEmployee(String EmployeeName,int EmployeeID,double MonthlySalary){
         super(EmployeeName,EmployeeID);
         this.MonthlySalary=MonthlySalary;

     }
     public double CalculationOfSalary(){
         return MonthlySalary;
     }
}
class parttimeEmployee extends employee{
    private int HourWork;
    private double HourlyRate;
    public parttimeEmployee( String Employeename,int EmployeeID,int HourWork,int HourlyRate){
        super(Employeename,EmployeeID);
        this.HourWork=HourWork;
        this.HourlyRate=HourlyRate;
    }

    @Override
    public double CalculationOfSalary() {
        return HourWork*HourlyRate;
    }
}
class payrollSystem{
    private ArrayList<employee> emp;
    public payrollSystem(){
        emp=new ArrayList<employee>();
    }
    public void addEmployee(employee Emplist){
        emp.add(Emplist);
    }
    public void removeEmployee(int id){
        employee temp=null;
        for(employee emp:emp){
            if(emp.getEmployeeID()==id){
                temp=emp;
                break;
            }

        }
        if(temp !=null){
            emp.remove(temp);
        }
        else{
            System.out.println("Not found");
        }
    }
    public void DisplayEmployee(){
        for(employee emp: emp){
            System.out.println(emp);
        }

    }
}
public class Main {
    public static void main(String[] args) {
        payrollSystem prs=new payrollSystem();
        parttimeEmployee pte=new parttimeEmployee("Sandhaya",1,6,1005);
        FullTimeEmployee fte=new FullTimeEmployee("Krishna",2,70000);
        prs.addEmployee(pte);
        prs.addEmployee(fte);
        System.out.println("Employee Details :    ");
        prs.DisplayEmployee();
    }
}