//package objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.awt.Rectangle;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import Window.Handler;
//import framework.ObjectId;
//
//class PlayerTest {
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//	void test() {
//		Handler handler = new Handler();
//		Player test = new Player(3*32, 18*32,handler, ObjectId.Player);
//		
//		assertEquals(64, test.height);
//		assertEquals(32, test.width);
//		
//		assertEquals(new Rectangle((int)((int)test.getX() + (32/2)-((32/2/2))), (int)((int) test.getY()
//				+ (64/2)),(int)32/2,(int)64/2), test.getBounds());
//		assertEquals(new Rectangle((int)test.getX(), (int) test.getY()+5,(int)5,(int)64-10), test.getBoundsLeft());
//		assertEquals(new Rectangle((int)((int)test.getX()+32 - 5), (int) test.getY()+5,(int)5,
//				(int)64-10), test.getBoundsRight());
//		assertEquals(new Rectangle((int)((int)test.getX() + (32/2)-((32/2/2))), (int) test.getY(),
//				(int)32/2,(int)64/2), test.getBoundsTop());
//		
//		
//		
//	
//	}
//
//}
