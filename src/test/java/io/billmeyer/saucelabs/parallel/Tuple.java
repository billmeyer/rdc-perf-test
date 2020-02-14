package io.billmeyer.saucelabs.parallel;

import java.io.Serializable;

public class Tuple<T1, T2> implements Serializable
{
    private T1 item1;
    private T2 item2;

    public Tuple()
    {

    }

    public Tuple(T1 T1, T2 T2)
    {
        this.item1 = T1;
        this.item2 = T2;
    }

    public T1 getItem1()
    {
        return this.item1;
    }

    public void setItem1(T1 item1)
    {
        this.item1 = item1;
    }

    public T2 getItem2()
    {
        return this.item2;
    }

    public void setItem2(T2 item2)
    {
        this.item2 = item2;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder(String.valueOf(this.getClass().getSimpleName()));
        sb.append("[item1=");
        sb.append(this.item1);
        sb.append(", item2=");
        sb.append(this.item2);
        sb.append("]");
        return sb.toString();
    }
}