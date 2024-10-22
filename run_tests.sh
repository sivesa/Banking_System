#!/bin/bash

# Navigate to the project directory
cd "$(dirname "$0")"

# Run Maven tests
mvn clean test

