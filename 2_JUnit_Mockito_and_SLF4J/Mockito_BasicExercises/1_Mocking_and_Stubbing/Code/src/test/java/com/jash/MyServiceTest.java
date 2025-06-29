package com.jash;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction(){
        ExternalAPI mockAPI = Mockito.mock(ExternalAPI.class);

        when(mockAPI.getData()).thenReturn("Hello Jashwanth");

        MyService service = new MyService(mockAPI);

        assertEquals("Hello Jashwanth", service.fetchData());
    }
}
