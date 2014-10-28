package JPL.ch02.ex02_17;

import com.StudyJava.*;

class testVehicle{

	public static void main ( String[] args ) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle("2");
                Vehicle C = new Vehicle("4");

                A.setSpeed(1); A.setAngle(1) ; A.setOwner("1");
                B.setSpeed(2); B.setAngle(2);
                C.setSpeed(4); C.setAngle(4);
		
		A.changeSpeed(30);
		B.stop();
		
		A.turn(A.eAngle.TURN_LEFT);
		B.turn(B.eAngle.TURN_RIGHT);
		C.turn(40);


                System.out.println(A.toString());
                System.out.println(B.toString());
   		System.out.println("accesser :" + " speed :" + C.getSpeed() 
						+ " angle : " + C.getAngle() 
						+ " owner :" + C.getOwner() 
						+ " id :" + C.getMyId() 
						+ " next :"  + C.getNextId());
        }

}
