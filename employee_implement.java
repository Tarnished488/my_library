package my_library;

public class employee_implement {
    private int employeeId;
    private Integer periodOfValidity;

    // Default constructor
    public employee_implement() {
    }

    // Parameterized constructor
    public employee_implement(int employeeId, Integer periodOfValidity) {
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
    public Integer getPeriodOfValidity() {
        return periodOfValidity;
    }

    // Setter for periodOfValidity
    public void setPeriodOfValidity(Integer periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }
}