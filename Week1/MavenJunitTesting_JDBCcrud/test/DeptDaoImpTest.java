package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import entity.Department;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.IDeptDao;
import dao.DeptDaoImp;

class DeptDaoImpTest {
	
	static IDeptDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new DeptDaoImp();
	}

	@Test
	@Disabled
	void testInsert() {
		Department dept = new Department();
		
		dept.setDno(170);
		dept.setDname("Chamania");
		dept.setLocation("Chandigarh");
		int actual = dao.insert(dept);
		assertEquals(1,actual);
		//assertNotEquals(1,actual);
	}

	
	@Test
	@Disabled
	void testUpdate() {
	    Department dept = new Department();

	    dept.setDno(160);  // Assuming you have an existing department with this DNO
	    dept.setDname("Quality Assurance");
	    dept.setLocation("Betma");

	    int actual = dao.update(dept);
	    assertEquals(1, actual);
	    //assertNotEquals(1, actual);
	}

	
	
	@Test
	@Disabled
	void testDeleteOne() {
	    int dnoToDelete = 170;  // Assuming you have an existing department with this DNO

	    int actual = dao.deleteOne(dnoToDelete);
	    assertEquals(1, actual);
	    //assertNotEquals(1, actual);
	}

	
	@Test
	@Disabled
	void testSelectOne() {
	    int dnoToSelect = 160;  // Assuming you have an existing department with this DNO

	    Department actual = dao.selectOne(dnoToSelect);
	    
	    assertNotNull(actual);
	    assertEquals(160, actual.getDno());
	    assertEquals("Quality Assurance", actual.getDname());
	    assertEquals("Betma", actual.getLocation());
	    // You may add more assertions based on your actual data
	}

	
	
	@Test
	void testSelectAll() {
		List<Department> list = dao.selectAll();
		Department dept = list.get(0);
		assertTrue(dept.getDno() > 0);
		assertNotNull(list);
		
		
	}

}
