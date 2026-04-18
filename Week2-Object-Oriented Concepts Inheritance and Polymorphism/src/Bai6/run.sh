#!/bin/bash
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR"

mkdir -p out

find . -name "*.java" > sources.txt

javac -encoding UTF-8 -cp ".;lib/*" -d out @sources.txt

java -cp "out;lib/*" Bai6.code.Account