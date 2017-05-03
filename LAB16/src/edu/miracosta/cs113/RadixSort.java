package edu.miracosta.cs113;

public class RadixSort
{
	static void sort( int[] a)
    {
        int max = a[0];
        int exp = 1; 
        int[] b = new int[10];
        
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
            }
        }
        
        while (max / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (int i = 0; i < a.length; i++)
            {
            	bucket[(a[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++)
            {
                bucket[i] += bucket[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--)
            {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (int i = 0; i < a.length; i++)
            {
                a[i] = b[i];
            }
            exp *= 10;        
        }
    }
}
