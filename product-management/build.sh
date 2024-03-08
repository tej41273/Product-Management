#!/bin/bash


# Creating the jar file
mvn clean install

#Build an application image
docker build . -t mainproduct2