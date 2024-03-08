#!/bin/bash

#Check availability of docker
if ! which docker > /dev/null; then
    echo "Error: Docker is not installed or not accessible in your PATH."
    exit 1
fi


# Check if build succeeded
IMAGE_NAME="mainproduct2"

if [ ! $(docker images -q mainproduct2:latest 2> /dev/null) ]; then
    /Users/tejakumar.kalimera/Downloads/Product-Management-Main/product-management/build.sh
else
  echo "${IMAGE_NAME} is already present"

fi


# Run Docker container
echo "Running Docker container..."

IMAGE1="mysql:5.7"
IMAGE2="mainproduct2:latest"

if docker ps -q --filter "ancestor=${IMAGE1}" | grep -q . && docker ps -q --filter "ancestor=${IMAGE2}" | grep -q .
then
  echo "Containers from both ${IMAGE1} and ${IMAGE2} are running."
  exit 1
else
  docker-compose -f /Users/tejakumar.kalimera/Downloads/Product-Management-Main/docker-compose.yml up -d
fi

echo "Backend project launched successfully!"