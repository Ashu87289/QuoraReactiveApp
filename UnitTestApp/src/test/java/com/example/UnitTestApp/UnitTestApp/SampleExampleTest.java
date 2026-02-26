package com.example.UnitTestApp.UnitTestApp;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class SampleExampleTest {

    int count;

    @BeforeAll
    void setUpBeforeAll(){
        System.out.println("Before All test Once");
    }

    @AfterAll
    void tearDownAfterAll(){
        System.out.println("After All Test Once");
    }

    @BeforeEach
    void setUp(){
        count = 0;
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After each Test");
    }


    @Test
    void testCountIncrement(){
        count++;
        System.out.println(count);
        assertEquals(1,count);
    }

    @Test
    void testCountIncrementPart2(){
        count++;
        System.out.println(count);
        assertEquals(1,count);
    }


    @Disabled("Fix later")
    @Test
    void testDivisionbyZero(){
        assertThrows(ArithmeticException.class,()-> {
            int x = 1/0;
        });
    }
}
