using System;
using System.Reflection;


class Program
{
    static void Main(string[] args)
    {
        int mark;
        Console.WriteLine("Ingrese calificacion");

        mark = int.Parse(Console.ReadLine());


        if (mark >= 5)
        {
            Console.WriteLine("PASS");
        }
        else
        {
            Console.WriteLine("FAIL");
        }





    }
}

