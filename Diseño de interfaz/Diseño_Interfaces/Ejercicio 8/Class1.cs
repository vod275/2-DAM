using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio_8
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            ArrayList arrayList = new ArrayList();

            arrayList.Add(1);
            arrayList.Add("Dos");
            arrayList.Add(3);

            foreach (var item in arrayList)
            {
                Console.WriteLine(item);
            }

            arrayList.Remove(1);


            Console.WriteLine("Lista Genereica despues de eliminar 2: ");

            foreach (var item in arrayList)
            {
                Console.WriteLine(item);
            }
        }
    }
}
