#!/usr/bin/env bash

checkResult() {
  if ! $1; then
    echo "$1 execute failed!"
    exit 1
  fi
}

echo "Code check start..."
echo "Running lint..."
checkResult "./gradlew lint"
echo "Running spotlessCheck..."
checkResult "./gradlew spotlessCheck"
echo "Running test..."
checkResult "./gradlew test"
echo "Running build..."
checkResult "./gradlew build"
