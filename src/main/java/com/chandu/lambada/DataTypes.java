package com.chandu.lambada;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataTypes {

    private Double instanceVar = Math.random();
    private static Double staticVar = Math.random();

    public DataTypes() {
        System.out.println("Inside Constructor");
    }

    static {
        System.out.println("Inside static block");
    }

    public void coldStartBasics() {
        Double localVar = Math.random();
        System.out.println("Instance: "+instanceVar+". StaticVar: "+staticVar+". LocalVar: "+localVar);
    }

    public int getNumber(float number) {
        return (int) number;
    }

    public ClinicalData getClinicalData(Person person) {
        System.out.println(person.name());
        System.out.println(person.ssn());
        return new ClinicalData("80/120", "80");
    }

    public void getOutput(InputStream inputStream, OutputStream outputStream,
                          Context context) throws IOException {
        System.out.println(System.getenv("restApi"));
        System.out.println(context.getAwsRequestId());
        System.out.println(context.getFunctionName());
        System.out.println(context.getRemainingTimeInMillis());
        System.out.println(context.getMemoryLimitInMB());
        System.out.println(context.getLogGroupName());
        int data;
        while ((data = inputStream.read()) != -1) {
            outputStream.write(Character.toLowerCase(data));
        }
    }


}

record Person(String name, String ssn){}
record ClinicalData(String bp, String heartRate){}

