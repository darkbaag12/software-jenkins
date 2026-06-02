package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {

	static StudentManager manager;
	@BeforeAll
	static void setUp() throws Exception {
		manager = new StudentManager();
	}

	@Order(1)
	@Test
	void testAddStudent() {
		manager.addStudent("steve");
		assertTrue(manager.hasStudent("steve"));
		assertThrows(IllegalArgumentException.class, () -> {
		    manager.addStudent("steve");
		});
		manager.removeStudent("steve");
	}
	@Order(2)
	@Test
	void testRemoveStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
		    manager.removeStudent("steve");
		});
		manager.addStudent("steve");
		manager.removeStudent("steve");
		assertFalse(manager.hasStudent("steve"));
		
	}
	@Order(3)
	@Test
	void testHasStudent() {
		manager.addStudent("steve");
		assertTrue(manager.hasStudent("steve"));
		manager.removeStudent("steve");
		assertFalse(manager.hasStudent("steve"));
	
	}

}
