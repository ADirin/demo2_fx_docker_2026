#!/bin/bash
# Start virtual display
Xvfb :99 -screen 0 1024x768x24 &
export DISPLAY=:99

# Wait for Xvfb to start
sleep 2

# Start JavaFX application (only controls module is needed for your code)
java --module-path=/usr/share/openjfx/lib \
     --add-modules=javafx.controls,javafx.graphics \
     -jar app.jar