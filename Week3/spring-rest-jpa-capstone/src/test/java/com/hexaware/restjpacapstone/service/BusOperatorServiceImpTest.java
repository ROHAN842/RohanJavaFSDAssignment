package com.hexaware.restjpacapstone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.restjpacapstone.dto.BusOperatorDTO;
import com.hexaware.restjpacapstone.entity.BusOperator;

@SpringBootTest
class BusOperatorServiceImpTest {

    @Autowired
    IBusOperatorService service;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @Test
    void testAddBusRoute() {
        BusOperatorDTO busRoute = new BusOperatorDTO();
        busRoute.setOperatorName("Test Bus");
        busRoute.setOperatorUsername("testuser");
        busRoute.setOperatorPassword("testpassword");
        busRoute.setEmail("test@example.com");
        busRoute.setPhoneNumber("1234567890");
        
     // Convert the registration date string to a Date object
        Date registrationDate = Date.valueOf("2022-03-11");
        busRoute.setRegistrationDate(registrationDate);;

        BusOperator addedBusOperator = service.addBusRoute(busRoute);

        assertNotNull(addedBusOperator);
        assertEquals("Test Bus", addedBusOperator.getOperatorName());
    }

    @Test
    void testGetAllBusRoutes() {
        List<BusOperator> busRoutes = service.getAllBusRoutes();

        assertFalse(busRoutes.isEmpty());
    }

    @Test
    void testDeleteBusOperatorById() {
        // Assuming a bus operator with ID 101 exists before deletion
        int operatorId = 653;

        // Delete the bus operator by ID
        String deletionResult = service.deleteBusOperatorById(operatorId);

        // Assert that the deletion was successful
        assertEquals("Bus Operator with ID " + operatorId + " deleted successfully.", deletionResult);

        // Try to retrieve the deleted bus operator from the server
        BusOperatorDTO deletedBusOperator = service.getBusOperatorById(operatorId);

        // Assert that the deleted bus operator is null, indicating that it has been deleted
        assertNull(deletedBusOperator);
    }
    
    @Test
    void testUpdateBusRoute() {
        // Create a new bus operator to be updated
        BusOperatorDTO busOperatorDTO = new BusOperatorDTO();
        busOperatorDTO.setOperatorName("Test Bus");
        busOperatorDTO.setOperatorUsername("testuser");
        busOperatorDTO.setOperatorPassword("testpassword");
        busOperatorDTO.setEmail("test@example.com");
        busOperatorDTO.setPhoneNumber("1234567890");
        busOperatorDTO.setRegistrationDate(Date.valueOf("2022-03-11"));

        // Add the bus operator to the database
        BusOperator addedBusOperator = service.addBusRoute(busOperatorDTO);

        // Update the bus operator's details
        int operatorId = addedBusOperator.getOperatorID(); // Get the bus operator ID
        busOperatorDTO.setOperatorName("Updated Test Bus");
        busOperatorDTO.setOperatorUsername("updatetestuser");
        busOperatorDTO.setOperatorPassword("testpassword");
        busOperatorDTO.setEmail("updated_test@example.com");
        busOperatorDTO.setPhoneNumber("9826130871");
        busOperatorDTO.setRegistrationDate(Date.valueOf("2025-05-06"));


        // Perform the update operation
        BusOperator updatedBusOperator = service.updateBusRoute(operatorId, busOperatorDTO);

        // Assert that the update operation was successful
        assertNotNull(updatedBusOperator);
        assertEquals(operatorId, updatedBusOperator.getOperatorID());
        assertEquals("Updated Test Bus", updatedBusOperator.getOperatorName());
        assertEquals("updated_test@example.com", updatedBusOperator.getEmail());
    }

    @Test
    void testDeleteBusOperatorByName() {
        // Add a bus operator to be deleted
        BusOperatorDTO busOperatorDTO = new BusOperatorDTO();
        busOperatorDTO.setOperatorName("Test Bus");
        busOperatorDTO.setOperatorUsername("testuser");
        busOperatorDTO.setOperatorPassword("testpassword");
        busOperatorDTO.setEmail("test@example.com");
        busOperatorDTO.setPhoneNumber("1234567890");
        busOperatorDTO.setRegistrationDate(Date.valueOf("2022-03-11"));

        // Add the bus operator to the database
        BusOperator addedBusOperator = service.addBusRoute(busOperatorDTO);

        // Delete the bus operator by name
        int deletedCount = service.deleteBusOperatorByName("Test Bus");

        // Assert that the deletion was successful
        assertTrue(deletedCount > 0);

        // Try to retrieve the deleted bus operator from the server
        BusOperatorDTO deletedBusOperator = service.getBusOperatorById(addedBusOperator.getOperatorID());

        // Assert that the deleted bus operator is null, indicating that it has been deleted
        assertNull(deletedBusOperator);
    }

    @Test
    void testGetNameStartWithA() {
        // Add some bus operators starting with 'A'
        service.addBusRoute(new BusOperatorDTO(0, "AB Bus", "testuser", "testpassword", "test@example.com", "1234567890", Date.valueOf("2022-03-11")));
        service.addBusRoute(new BusOperatorDTO(0, "AC Bus", "testuser", "testpassword", "test@example.com", "1234567890", Date.valueOf("2022-03-11")));

        // Get all bus operators whose name starts with 'A'
        List<BusOperator> operators = service.getNameStartWithA("A");

        // Print the list of operators for debugging
        System.out.println("Operators with name starting with 'A':");
        for (BusOperator operator : operators) {
            System.out.println(operator);
        }
        
        // Assert that at least two operators are retrieved
        assertFalse(operators.size() >= 2);
    }

    @Test
    void testGetBusOperatorById() {
        // Add a bus operator
        BusOperatorDTO busOperatorDTO = new BusOperatorDTO();
        busOperatorDTO.setOperatorName("Test Bus");
        busOperatorDTO.setOperatorUsername("testuser");
        busOperatorDTO.setOperatorPassword("testpassword");
        busOperatorDTO.setEmail("test@example.com");
        busOperatorDTO.setPhoneNumber("1234567890");
        busOperatorDTO.setRegistrationDate(Date.valueOf("2022-03-11"));

        // Add the bus operator to the database
        BusOperator addedBusOperator = service.addBusRoute(busOperatorDTO);

        // Get the added bus operator by ID
        BusOperatorDTO retrievedBusOperator = service.getBusOperatorById(addedBusOperator.getOperatorID());

        // Assert that the retrieved bus operator is not null
        assertNotNull(retrievedBusOperator);
        assertEquals(addedBusOperator.getOperatorID(), retrievedBusOperator.getOperatorID());
        assertEquals("Test Bus", retrievedBusOperator.getOperatorName());
    }

}
