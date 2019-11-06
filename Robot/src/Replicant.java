import java.util.Random;

public class Replicant {

	MarkJava RobotQueReplicara;
	
	
	void interectua(MarkJava altreRobot){
		RobotQueReplicara= altreRobot;
	}
	
	
	boolean decideixSiMou() {
		if(RobotQueReplicara.energia < 7) {
			return false;
		}else {
			Random rnd = new Random(10);
			int i = rnd.nextInt();
			if(i>=6) {
				return true;
			}else {
				return false;
			}
		}
	
	
	}
	
	MarkJava construeix() {
		if(RobotQueReplicara.energia < 7) {
			return null;
		}
		
	}
	
	
	
}
