#!/bin/bash
# This is cehcking java avilable or not
echo "$(java -version)"

# This line executing second jar file and puting as background process using opertaor( & )
java -jar /opt/lib/app.jar 