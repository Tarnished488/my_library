package my_library;

import javax.persistence.*;

@Entity
@Table(name = "fine_rule")
public class fine_rules {

    @Id
    @Column(name = "Damage_fine", nullable = false)
    private int damageFine; // 损坏罚款，作为主键

    @Column(name = "Loss_fine", nullable = true)
    private Integer lossFine; // 丢失罚款，可为空

    @Column(name = "Overtime_fine", nullable = true)
    private Integer overtimeFine; // 超期罚款，可为空

    @Column(name = "Period_of_validity", nullable = true)
    private Integer periodOfValidity; // 有效期，可为空

    // 默认构造函数
    public fine_rules() {}

    // 参数化构造函数
    public fine_rules(int damageFine, Integer lossFine, Integer overtimeFine, Integer periodOfValidity) {
        this.damageFine = damageFine;
        this.lossFine = lossFine;
        this.overtimeFine = overtimeFine;
        this.periodOfValidity = periodOfValidity;
    }

    // Getter 和 Setter 方法
    public int getDamageFine() {
        return damageFine;
    }

    public void setDamageFine(int damageFine) {
        this.damageFine = damageFine;
    }

    public Integer getLossFine() {
        return lossFine;
    }

    public void setLossFine(Integer lossFine) {
        this.lossFine = lossFine;
    }

    public Integer getOvertimeFine() {
        return overtimeFine;
    }

    public void setOvertimeFine(Integer overtimeFine) {
        this.overtimeFine = overtimeFine;
    }

    public Integer getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Integer periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    @Override
    public String toString() {
        return "FineRule{" +
               "damageFine=" + damageFine +
               ", lossFine=" + lossFine +
               ", overtimeFine=" + overtimeFine +
               ", periodOfValidity=" + periodOfValidity +
               '}';
    }
}
