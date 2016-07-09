package java_employee_gui_project;

public class Employee{
    
    private String emp_name;
    private int emp_id;
    static int count=0;
    
    Employee(String s,int n){
        this.emp_name=s;
        this.emp_id=n;
        count++;
    }
    Employee(){
    }
    
    String getEmployeeName(){
        return(this.emp_name);
    }
    int getEmployeeId(){
            return(this.emp_id);
    }
    @Override
    public String toString(){
            return("Name:"+this.emp_name+"\tId:"+this.emp_id);
    }
}