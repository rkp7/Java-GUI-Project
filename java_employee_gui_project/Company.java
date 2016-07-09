package java_employee_gui_project;

class Company {

    private String empname;
    private String name;
    private int id;
    private double bs;
    private double sales;
    private double hours;
    private double rate;
    
    SalariedEmployee Semp[]=new SalariedEmployee[20];
    BaseSalariedCommissionEmployee BSCemp[]=new BaseSalariedCommissionEmployee[20];
    HourlyEmployee Hemp[]=new HourlyEmployee[20];
    
    Company(String s)
    {
      this.name=s;
    }

    void createSemployee(String empname,int id,double bs){

        Semp[SalariedEmployee.scount]=new SalariedEmployee(empname,id,bs);
    
    }

    void createBSCemployee(String empname,int id,double bs,double sales){

        BSCemp[BaseSalariedCommissionEmployee.bsccount]=new BaseSalariedCommissionEmployee(empname,id,bs,sales);

    }

    void createHemployee(String empname,int id,double rate,double hours){

        Hemp[HourlyEmployee.hcount]=new HourlyEmployee(empname,id,rate,hours);

    }

    SalariedEmployee[] getSemp(){
        return(this.Semp);
    }

    BaseSalariedCommissionEmployee[] getBSCemp(){
        return(this.BSCemp);
    }

    HourlyEmployee[] getHemp(){
        return(this.Hemp);
    }

    String getCompanyName(){
        return(this.name);
    }

    void setCompanyName(String str){
        this.name=str;
    }
}