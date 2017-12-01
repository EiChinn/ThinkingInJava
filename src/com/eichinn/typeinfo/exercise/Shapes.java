package com.eichinn.typeinfo.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw();");
    }
    void rotate() {
        System.out.println(this + ".rotate();");
    }
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }

    @Override
    void rotate() {
        throw new UnsupportedOperationException("Circle do not has rotate operation");
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}
class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());

        for (Shape shape : shapes) {
            shape.draw();
            rotate(shape);
        }

        Shape shape = new Rhomboid();
        //Ex3
        ((Rhomboid)shape).draw();
//        ((Circle)shape).draw();

        //Ex4
        if (shape instanceof Rhomboid) {
            ((Rhomboid)shape).draw();
        }
        if (shape instanceof Circle) {
            ((Circle)shape).draw();
        }
    }

    static void rotate(Shape shape) {
        if (!(shape instanceof Circle)) {
            shape.rotate();
        }
    }
}


