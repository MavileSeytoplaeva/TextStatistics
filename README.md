# Консольное приложение на Java, для расчета статистики по тексту.

Приложение принимает в командной строке 3 имени файлов. **Первый файл** – текст для анализа. **Второй файл** – перечень шаблонов для расчета статистики. **Третий файл** для вывода результата.

#### Шаблоны имеют следующий формат:

* а1б2в1 – означает, что слово должно одновременно содержать 1 букву «а», 2 буквы «б» и 1 букву «в»;
* "абр" – означает, что слово должно содержать последовательность символов в кавычках (например, «швабра»).

##### Приложение выводит таблицу с количеством подходящих слов по каждому шаблону.

Оценивается корректность работы приложения, производительность, оптимальность и качество кода и обработка ошибок. Допускается многопоточная реализация.

#### Пример входных данных и результата:


| Текст (1й файл)                                                     | Шаблоны (2й файл) | Результат (3й файл)                                                                                                                    |
|---------------------------------------------------------------------| ----------- |----------------------------------------------------------------------------------------------------------------------------------------|
| Отец мой Андрей Петрович Гринев в молодости своей служил при графе Минихе и вышел в отставку премьер-майором в 17.. году.| о2<br> т1о1<br>"ми" <br>ф2 <br>11 <br>"йо" <br>    | о2 --------- 2 <br>т1о1--------3 <br>"ми"--------	0 <br>ф2----------	0 <br>11-----------	1 <br>"йо"---------	1 <br>й1о1--------	3 <br> |




