# Java-course
Практические задания:
I OOP-basic
1. Создать классы Собака, Домашний Кот, Тигр, Животное (можете добавить два-три своих класса)
2. Животные могут бежать и плыть В качестве аргумента каждому метаду передается длина препятствия
3. У каждого животного есть ограничения на действия (бег кот — 200 м. собака — 500 м; 
   плавание кот — не умеет плавать, собака — 10 м) Результатом выполнения действия будет печать 
   в консоль Например  dogBobik.run(1S0); -> 'Бобик пробежал 150 м'
4. Создать один массив с животными и заставляете их по очереди пробежать дистанцию и проплыть.
5. * Добавить подсчет созданных Домашних Котов Тигров Собак Животных

- в пакете animalRefactor показано отличное решение с сокращением кода

II OOP-advanced

Оработка прктических навыков по работе с интерфейсами 
1. Продолжаем работать с участниками и выполнением действий Создайте три класса Человек,
   Кот, Робот которые не наследуются от одного класса Эти классы должны уметь бегать и прыгать
   все также с выводом информации о действии в консоль
2. Создайте два класса беговая дорожка и стена, при прохождении через которые, участники должны выполнять
   соответствующие действия (бежать или прыгать) результат выполнения печатаем в консоль (успешно пробежал,
    не смог пробежать и тд) у препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения 
    на бег и прыжки.
3. Создайте два массива с Участниками и препятствияии и заставьте всех участников пройти этот набор препятствий.
   Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет

III Exception
 
 1. Создайте исключения: MyArraySizeException (неправильный размер массива), 
    и MyArrayDataException (в ячейке массива лежит что-то не то);
 2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) 
    размером 4x4. При подаче массива другого размера необходимо бросить исключение 
    MyArraySizeException.
 3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. 
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), 
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. 
    Расчет данных для этой матрицы прекращается.
 4. В методе main() нужно вызвать полученный метод, обработать возможные исключения MySizeArrayException и 
    MyArrayDataException и вывести результат расчёта. Заметка: для  преобразования  строки  в  число  можно  
    использовать  метод класса  Integer: Integer.valueOf("l")
    
IV Collection

1.  Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).
2.  Написать метод, который преобразует массив в ArrayList.
3. Задача:
 a. Даны классы Fruit -> Apple, Orange.
 b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу  фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.
 c. Для хранения фруктов внутри коробки можно использовать ArrayList.
 d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного  фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
    важны).
 e. Внутри класса Box написать метод Compare, который позволяет сравнить текущую  коробку с той, которую подадут в Compare в качестве параметра. True, если их массы
    равны, False — в противном случае. Можно сравнивать коробки с яблоками и  апельсинами.
 f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
 Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
 объекты, которые были в первой.
 g. Не забываем про метод добавления фрукта в коробку.   