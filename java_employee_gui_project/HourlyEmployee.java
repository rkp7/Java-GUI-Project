package java_employee_gui_project;

class HourlyEmployee extends Employee{
    private double base_salary;
    private double overtime;
    private double final_income;
    private double hours;
    private double rate;
    static int hcount=0;
    
    HourlyEmployee(String n,int id,double r,double h){
        super(n,id);
        this.rate=r;
        this.hours=h;
        hcount++;
        this.calculateBaseSalary();
        this.calculateOvertime();
        this.calculateFinalIncome();
    }
    
    void calculateBaseSalary(){
        if(this.hours<=40)
        {
            this.base_salary=this.hours*this.rate;
        }
        else
        {
            this.base_salary=40*this.rate;
        }
    }
    void calculateOvertime(){
        if(this.hours<=40)
        {
            this.overtime=0;
        }
        else
        {
            this.overtime=(this.hours-40)*this.rate*2;
        }
    }
    void calculateFinalIncome(){
     
        this.final_income=this.base_salary+this.overtime;
    }
    double getFinalIncome(){
        return(this.final_income);
    }
    @Override
    public String toString(){
        return("\nName:"+super.getEmployeeName()+"\nId:"+super.getEmployeeId()+"\nBase salary:"
            +this.base_salary+"\nOvertime:"+this.overtime+
            "\nFinal Income:"+this.final_income);
    }
    
    
}
