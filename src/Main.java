import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    /*
    План занятия
    1) CallBacks
    2) Лямбды
     */

    /*
    Теория
    Callback(обратный вызов) - т.е. в коде очень часто возникает необходимость применить алгоритм не в зависимости от данных,
    а в зависимости от какой-то операции - по факту callback подразумевает передачу методов в качестве аргумента

    C точки зрения информатики(архитектура Фон Неймана) можно оперировать информацией как данным(числа, строки и т.д.) и
    как операциями(методы, объекты и т.п.)

    Колбеки позволяют корректировать работу общего алгоритма под нужды конкретной задачи

    Лямбды - операции(фунциональные интерфейсы) - т.е. реализация интерфейса имеющего всего один метод

   Шаблон для написания лямбды:

   (параметры) -> {Действия}, если действие одно, фигурные скобки можно не ставить
     */

    /*
    Заметки
    Явный приммер колбека - Comparator
    Примерами функциональных интерфесов в Java являются Runnable, Сomparable

    Мы подошли к нововведениям языка Java, если  вдруг у Вас код не выполняется, то необходимо пройти в File-> projectSctrutcure->
    -> Project -> language level и выбрать правильную версию языка и SDK

    Существует понятие той версии под, которую пишется проект - target version. В случае возникновения проблем переходим
    в File -> Settings -> Build, Execition, Deployment и выбираем Compiler в нем, можно указывать целевые версии платформы

    Вывод: существуют нюансы сборки проекта и мы в плотную подошли к тому, чтобы с ними столкнуться, в случае проблем, две
    указанные выше ссылки в сочетании с документацией от Intelij Idea позволят собрать проект под Ваши потребности
     */

    public static void main(String[] args) {
      print(10);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(12000, 120, "BMW"));
        cars.add(new Car(10000, 150, "Mercedes"));
        cars.add(new Car(9000, 90, "Ford"));
        System.out.println(cars);

        Collections.sort(cars, (o1, o2) -> (int)o1.getSpeed() - (int)o2.getSpeed());

        /*
        Задача
        Реализовать механизм колбека
         */

        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();

        //TODO Заменить создание объектов лямбдами
        //инициализируем колбек, передавая методу registerCallBack экземпляр MyClass, реализующий интерфейс колбек
        someClass.registerCallBack(myClass);
        someClass.doSomething();

        // Создадим еще один Callback
        StudentClass studentClass = new StudentClass();
        someClass.registerCallBack(studentClass);
        someClass.doSomething();

        /*
        Задача
        Создать функциональный интерфейс и инициализировать его через лямбды
         */

        MyInterface myInterface;

        myInterface = () -> 3.14;  // Присваиваем функциональному интерфейсу конкретное значение

        System.out.println("Результат лямбды: " + myInterface.getValue());

        // Изменить функционал лямбды. Вывести текст и значение 5.3

        myInterface = () -> {
            System.out.println("Выводим произвольное число:");
            return 5.3;
        };

        System.out.println("Результат лямбды: " + myInterface.getValue());

        /*
        Сделать функциональный интерфейс с параметрами
         */
        ParamInterface paramInterface;
        paramInterface = (a, b) -> {System.out.println("a = " + a + " b = " + b);};
        paramInterface.doSomething(2, 4.5);

    }

    public static void print(int i){
        System.out.println(i);
    }

    /*
    ДЗ
    1)Доделать пример с колбеками - реализовать ввод пользователя(описание в статье): http://www.fandroid.info/urok-13-osnovy-java-metody-obratnogo-vyzova-callback/
    2) Разобрать статью про лямбды - задача реализовать два вида сортировки списка массивов строк по длинк слов и по длине
    массивов: https://javarush.com/groups/posts/lambda-vihrazhenija-v-java-chast-1
    3*) Сделать свою реализацию универсального алгоритма сортировки(пузырек или что-то на Ваш вкус) через компараторы(своя версия)
    4**) Выполнить задачу 3 c алгоритмом быстрой сортировки. *Задуматься почему эта сортиовка превосходит все остальные по
    быстродействию(Паралелльные вычисления) - Теориетический минимум по Computer Science - быстрая сортировка.
    5*) Реализовать через лямбду Runnable


     */
}
