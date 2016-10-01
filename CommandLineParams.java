/*Модифицируйте код программы так, чтобы параметры командной строки выводились в обратном порядке. Исправьте программу в соответствии со стандартом кодирования.
public class CommandLineParams
{
public static void main(String[] args)
        {
        for(int i = 0; i < args.length; i++)
        {
            System.out.println("Аргумент " + i + " = " + args[i]);
        }
    }
}

 */
public class CommandLineParams {
    public static void main(String[] args) {
        //цикл для вывода параметров командной строки в обратном порядке args[j--]
        for (int j = (args.length - 1); j >= 0; j--) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + i + "=" + args[j--]);
            }
        }
    }
}