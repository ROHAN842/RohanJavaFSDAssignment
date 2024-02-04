package com.hexaware.restjpacapstone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.hexaware.restjpacapstone.dto.BusOperatorDTO;
import com.hexaware.restjpacapstone.entity.BusOperator;
import com.hexaware.restjpacapstone.exception.BusOperatorNotFoundException;

@SpringBootTest
class BusOperatorControllerTest {

    @Autowired
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testInsertBusRoute() {
        BusOperatorDTO busOperatorDTO = new BusOperatorDTO();
        busOperatorDTO.setOperatorName("Abhi Bus");

        ResponseEntity<BusOperator> response = restTemplate.postForEntity(
                "http://localhost:8080/api/busoperator/add", busOperatorDTO, BusOperator.class);
        BusOperator insertedBusOperator = response.getBody();
        assertNotNull(insertedBusOperator);
        assertEquals("Abhi Bus", insertedBusOperator.getOperatorName());
    }

    @Test
    void testGetBusOperatorById() {
        int operatorId = 4;

        ResponseEntity<BusOperatorDTO> response = restTemplate.getForEntity(
                "http://localhost:8080/api/busoperator/get/" + operatorId, BusOperatorDTO.class);
        BusOperatorDTO busOperatorDTO = response.getBody();
        assertNotNull(busOperatorDTO);
        assertEquals(operatorId, busOperatorDTO.getOperatorID());
    }

    @Test
    void testDeleteBusOperatorById_BusOperatorNotFoundException() {
        // Specify the ID of the bus operator to be deleted
        int operatorId = 302;

        // Send a DELETE request to delete the bus operator with the specified ID
        restTemplate.delete("http://localhost:8080/api/busoperator/deleteById/" + operatorId);

        // Try to retrieve the deleted bus operator from the server
        try {
            ResponseEntity<BusOperator> response = restTemplate.getForEntity("http://localhost:8080/api/busoperator/get/" + operatorId, BusOperator.class);
            
            // If the retrieval is successful, fail the test
            fail("Expected HttpClientErrorException.BadRequest, but no exception was thrown");
        } catch (HttpClientErrorException.BadRequest ex) {
            // Assert that the exception status code is 400 (Bad Request)
            assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
            // Assert that the exception message contains the expected error message
            assertTrue(ex.getMessage().contains("Bus Operator Not Found for Operator ID: " + operatorId));
        }
        
    }



    @Test
    void testGetAll() {
        ResponseEntity<List> response = restTemplate.getForEntity(
                "http://localhost:8080/api/busoperator/getall", List.class);
        List<BusOperator> busOperators = response.getBody();
        assertNotNull(busOperators);
        assertTrue(busOperators.size() > 0);
    }
    
//    @Test
//    void testGetByEnameStartWithA() {
//        ResponseEntity<List> response = restTemplate.getForEntity(
//                "http://localhost:8080/api/busoperator/getbyenamestartwithA?operator=A", List.class);
//        List<BusOperator> busOperators = response.getBody();
//        assertNotNull(busOperators);
//        assertFalse(busOperators.isEmpty());
//        for (BusOperator busOperator : busOperators) {
//            assertTrue(busOperator.getOperatorName().startsWith("A"));
//        }
//    }

    @Test
    void testDeleteBusOperatorByName() {
        String operatorName = "Abhi Bus";
        ResponseEntity<Integer> response = restTemplate.exchange(
                "http://localhost:8080/api/busoperator/deleteByName/" + operatorName, 
                HttpMethod.DELETE, null, Integer.class);
        int deletedCount = response.getBody();
        assertEquals(1, deletedCount);
    }

    @Test 
    void testUpdateBusRoute() {
        int operatorId = 202;
        BusOperatorDTO updatedBusOperatorDTO = new BusOperatorDTO();
        // Set properties of updatedBusOperatorDTO

        ResponseEntity<BusOperator> response = restTemplate.exchange(
                "http://localhost:8080/api/busoperator/update/" + operatorId, 
                HttpMethod.PUT, new HttpEntity<>(updatedBusOperatorDTO), BusOperator.class);
        BusOperator updatedBusOperator = response.getBody();
        assertNotNull(updatedBusOperator);
        // Add assertions to verify the updated bus operator
    }
}
