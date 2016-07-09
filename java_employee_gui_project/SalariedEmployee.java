package java_employee_gui_project;

class SalariedEmployee extends Employee{
    
    private double salary;
    static int scount=0;
    
    SalariedEmployee(String n,int id,double s){
          super(n,id);
          this.salary=s;
          scount++;
    }
    
    double getsalary(){
        return(this.salary);
    }
    @Override
    public String toString(){
      return("\nName:"+super.getEmployeeName()+"\nId:"+super.getEmployeeId()+"\nSalary:"+this.salary);
    }    
}