@echo off
REM
REM   This script is for compiling the scss source files into css files
REM   It produces a minified output
sass --watch src/main/resources/static/scss:src/main/resources/static/css --style compressed