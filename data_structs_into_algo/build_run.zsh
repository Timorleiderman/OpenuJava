#!/bin/zsh

javac Main.java
java Main > test.log
python3 analyze.py