/*
    Bhaiya Faisal : Problem Solved with the help of default method in interface implementation
    //can't override the static method, and can be or cannot be , but must have to implement all the signature methods
 */



package com.dot.dot_db_android;
public interface Simple
{
    public void call();
    static void si()
    {

    }
    default void hi(){

    }
}
class ok implements Simple
{
    @Override
    public void hi() {

    }


    public ok()
    {
        Simple simple = new ok();



    }

    @Override
    public void call() {

    }
}
