package my_library;

public class employee_implement {
    private int employeeId;
    private int periodOfValidity;

    // Default constructor
    public employee_implement() {
    }

    // Parameterized constructor
    public employee_implement(int employeeId, int periodOfValidity) {
        this.employeeId = employeeId;
        this.periodOfValidity = periodOfValidity;
    }

    // Getter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    // Setter for employeeId
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getter for periodOfValidity
    //public int getPeriodOfValidity() {
     //   return periodOfValidity;
    //}

    // Setter for periodOfValidity
    public void setPeriodOfValidity(int periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }
}
