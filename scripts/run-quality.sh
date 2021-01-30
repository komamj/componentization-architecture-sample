#!/usr/bin/env bash

echo "Running tests..."
./gradlew clean && ./gradlew lint && ./gradlew spotlessCheck && ./gradlew test && ./gradlew build
status=$?
if [ "$status" = 0 ]; then
  echo "Code check successful!"
  exit 0
else
  echo "Code check failed!"
  exit 1
fi
