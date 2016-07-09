package java_employee_gui_project;

class BaseSalariedCommissionEmployee extends Employee{
    
    private double base_salary=0;
    private double commission=0;
    private double reward=0;
    private double final_income=0;
    private double sales=0;
    static int bsccount=0;
    
    BaseSalariedCommissionEmployee(String n,int id,double b,double s){
        super(n,id);
        this.base_salary=b;
        this.sales=s;
        bsccount++;
        this.calculateCommission();
        this.calculateReward();
        this.calculateFinalIncome();
    }
    void calculateCommission(){
        this.commission=0.30*this.sales;
    }
    void calculateReward(){
        this.reward=0.1*this.base_salary;
    }
    void calculateFinalIncome(){
        this.final_income=this.base_salary+this.commission+this.reward;
    }
    double getFinalIncome(){
      return(final_income);  
  }
  @Override
  public String toString(){
    return("\nName:"+super.getEmployeeName()+"\nId:"+super.getEmployeeId()+"\nBase salary:"
        +this.base_salary+"\nCommission:"+this.commission+
        "\nReward:"+this.reward+"\nFinal Income:"+this.final_income);
}
}