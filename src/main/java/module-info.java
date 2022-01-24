module eu.naruciakk.nbpusd {
    requires javafx.controls;

    requires unirest.java;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires java.sql;

    opens eu.naruciakk.nbpusd.models to com.fasterxml.jackson.databind;

    exports eu.naruciakk.nbpusd;
    exports eu.naruciakk.nbpusd.models;
}