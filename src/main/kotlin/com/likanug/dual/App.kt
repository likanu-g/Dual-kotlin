package com.likanug.dual

import processing.core.PApplet

class App : PApplet() {
    override fun settings() {
        size(400, 400)
    }

    override fun setup() {
        background(220)
    }

    override fun draw() {
        ellipse(mouseX.toFloat(), mouseY.toFloat(), 50F, 50F)
    }
}

fun main() {
    PApplet.main("com.likanug.dual.App")
}

