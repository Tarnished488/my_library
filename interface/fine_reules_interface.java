package my_library;

public interface fine_reules_interface {
	
	// get loss fine from student library card and employee library card
	Integer getLossFine();
	
	// get overtime fine from student library card and employee library card
	Integer getOvertimeFine();
	
	// get damage fine from student library card and employee library card
	int getDamageFine();
	
	// calculate the total fine 
	default int calculateTotalFine() {
        int total = 0;
        Integer lossFine = getLossFine();
        Integer overtimeFine = getOvertimeFine();

        if (lossFine != null) total += lossFine;
        if (overtimeFine != null) total += overtimeFine;
        total += getDamageFine(); // damageFine ²»¿ÉÎª¿Õ

        return total;
    }
	

}
