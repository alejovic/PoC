package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("spring-boot-poc")
public class PropertyPoC {

    @Value("${spring-boot-poc.property1}")
    private String property;

    private String property2;

    // @Value("${spring-boot-poc.properties}") does not work
    private List<ArrayProperty> properties = new ArrayList<>();

    @Value("#{'${spring-boot-poc.list.properties}'.split(';')}")
    //@Value("${spring-boot-poc.list.properties}") works!
    private List<String> propertiesList;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public List<ArrayProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ArrayProperty> properties) {
        this.properties = properties;
    }

    public List<String> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @Override
    public String toString() {
        return "PropertyPoC{" +
                "property='" + property + '\'' +
                ", property2='" + property2 + '\'' +
                ", properties=" + properties +
                ", propertiesList=" + propertiesList +
                '}';
    }

    public static class ArrayProperty {
        private String property1;
        private String property2;

        public String getProperty1() {
            return property1;
        }

        public void setProperty1(String property1) {
            this.property1 = property1;
        }

        public String getProperty2() {
            return property2;
        }

        public void setProperty2(String property2) {
            this.property2 = property2;
        }

        @Override
        public String toString() {
            return "ArrayProperty{" +
                    "property1='" + property1 + '\'' +
                    ", property2='" + property2 + '\'' +
                    '}';
        }
    }
}
