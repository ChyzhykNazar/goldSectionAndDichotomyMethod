package com.company;

import static java.lang.StrictMath.abs;

class function{
    public static double func1(double x){
        return (x-15)*(x-15);
    }
    public static double func2(double x){
        return (x-15)*(x-15) - (15 * x);
    }
    public static double func3(double x){
        return (x-15)*(x-15) + (15 * (x * x));
    }
}

class fopt{
    public static double fopt1(){
        return 0;
    }
    public static double fopt2(){
        return -281.25;
    }
    public static double fopt3(){
        return 210.938;
    }
}

class dyhytomia{
    public static void aVoid(double start, double end, int kmax, double delta, double eps){
        double p = 0;
        double q = 0;
        double [] a = new double[kmax + 1];
        double [] b = new double[kmax + 1];
        int k = 0;
        a[k] = start;
        b[k] = end;
        while((b[k] - a[k]) > eps && k < kmax)
        {
            p = (a[k] + b[k]) / 2.0 - delta;
            q = (a[k] + b[k]) / 2.0 + delta;
            if(function.func1(p) < function.func1(q)){
                a[k + 1] = a[k];
                b[k + 1] = q;
            }else{
                a[k + 1] = p;
                b[k + 1] = b[k];
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println("f_min[" + k + "] = " + function.func1((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func1(a[k]) - fopt.fopt1()));
            System.out.println();
            k++;
        }
        System.out.println("Function 1");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
        k=0;
        a[k] = start;
        b[k] = end;
        while((b[k] - a[k]) > eps && k < kmax)
        {
            p = (a[k] + b[k]) / 2.0 - delta;
            q = (a[k] + b[k]) / 2.0 + delta;
            if(function.func2(p) < function.func2(q)){
                a[k + 1] = a[k];
                b[k + 1] = q;
            }else{
                a[k + 1] = p;
                b[k + 1] = b[k];
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println("f_min[" + k + "] = " +function.func2((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func2(a[k]) - fopt.fopt2()));
            System.out.println();
            k++;
        }
        System.out.println("Function 2");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
        k=0;
        a[k] = start;
        b[k] = end;
        while((b[k] - a[k]) > eps && k < kmax)
        {
            p = (a[k] + b[k]) / 2.0 - delta;
            q = (a[k] + b[k]) / 2.0 + delta;
            if(function.func3(p) < function.func3(q)){
                a[k + 1] = a[k];
                b[k + 1] = q;
            }else{
                a[k + 1] = p;
                b[k + 1] = b[k];
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println("f_min[" + k + "] = " + function.func3((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func3(a[k]) - fopt.fopt3()));
            System.out.println();
            k++;
        }
        System.out.println("Function 3");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
    }
}

class gold_section{
    public static void goldSection(double start, double end, int kmax, double delta, double eps){
        System.out.println("\nGold Section\n");
        double [] p = new double[kmax + 1];
        double [] q = new double[kmax + 1];
        double [] a = new double[kmax + 1];
        double [] b = new double[kmax + 1];
        /*Function 1*/
        int k = 0;
        a[k] = start;
        b[k] = end;
        p[k] = a[k] + (1 - 0.618)*(b[k] - a[k]);
        q[k] = a[k] + 0.618 * (b[k] - a[k]);
        while((b[k] - a[k]) > eps && k < kmax)
        {
            if(function.func1(p[k]) > function.func1(q[k])){
                a[k + 1] = p[k];
                b[k + 1] = b[k];
                p[k + 1] = q[k];
                q[k + 1] = a[k + 1] + 0.618 * (b[k + 1] - a[k + 1]);
            }else{
                a[k + 1] = a[k];
                b[k + 1] = q[k];
                q[k + 1] = p[k];
                p[k + 1] = a[k + 1] + 0.382 * (b[k + 1] - a[k + 1]);
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println("f_min[" + k + "] = " + function.func1((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func1(a[k]) - fopt.fopt1()));
            System.out.println();
            k++;
        }
        System.out.println("Function 1");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
        /*Function 2*/
        k = 0;
        a[k] = start;
        b[k] = end;
        p[k] = a[k] + (1 - 0.618)*(b[k] - a[k]);
        q[k] = a[k] + 0.618 * (b[k] - a[k]);
        while((b[k] - a[k]) > eps && k < kmax)
        {
            if(function.func2(p[k]) > function.func2(q[k])){
                a[k + 1] = p[k];
                b[k + 1] = b[k];
                p[k + 1] = q[k];
                q[k + 1] = a[k + 1] + 0.618 * (b[k + 1] - a[k + 1]);
            }else{
                a[k + 1] = a[k];
                b[k + 1] = q[k];
                q[k + 1] = p[k];
                p[k + 1] = a[k + 1] + 0.382 * (b[k + 1] - a[k + 1]);
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println("f_min[" + k + "] = " + function.func2((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func2(a[k]) - fopt.fopt2()));
            System.out.println();
            k++;
        }
        System.out.println("Function 2");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
        /*Function 3*/
        k = 0;
        a[k] = start;
        b[k] = end;
        p[k] = a[k] + (1 - 0.618)*(b[k] - a[k]);
        q[k] = a[k] + 0.618 * (b[k] - a[k]);
        while((b[k] - a[k]) > eps && k < kmax)
        {
            if(function.func3(p[k]) > function.func3(q[k])){
                a[k + 1] = p[k];
                b[k + 1] = b[k];
                p[k + 1] = q[k];
                q[k + 1] = a[k + 1] + 0.618 * (b[k + 1] - a[k + 1]);
            }else{
                a[k + 1] = a[k];
                b[k + 1] = q[k];
                q[k + 1] = p[k];
                p[k + 1] = a[k + 1] + 0.382 * (b[k + 1] - a[k + 1]);
            }
            System.out.println("x_min[" + k + "] = " + (a[k] + b[k]) / 2.0);
            System.out.println(function.func3((b[k] + a[k]) / 2.0));
            System.out.println("z[" + k + "] = " + abs(function.func3(a[k]) - fopt.fopt3()));
            System.out.println();
            k++;
        }
        System.out.println("Function 1");
        System.out.println("Count of itterations = " + k);
        System.out.println("The minimum point belongs to the interval[ " + a[k - 1] + " ; " + b[k - 1] + " ]");
        System.out.println();
    }
}
public class Main {

    public static void main(String[] args) {
        double delta = 0.0001;
        double eps = 0.001;
        double start = -15;
        double end = 30;
        int kmax = 20;
        dyhytomia.aVoid(start,end, kmax, delta, eps);
        gold_section.goldSection(start,end, kmax, delta, eps);
    }
}
