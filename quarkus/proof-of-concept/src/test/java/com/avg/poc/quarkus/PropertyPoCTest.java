package com.avg.poc.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PropertyPoCTest {

    @Inject
    PropertyPoC property;

    @InjectMock
    PropertyPoC propertyMock;

    @Test
    @Transactional
    public void whenAValidPropertyFile_willBeDisplayed() {
        System.out.println(property.property2());
    }

    @Test
    public void whenValidProperty_willbeMocked() {
        Mockito.when(propertyMock.property2()).thenReturn("mocked-app");
        assertEquals("mocked-app", propertyMock.property2());
    }

}
