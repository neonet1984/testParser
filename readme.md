Автотест для Конвертера
====================
Автотест проверяет, корректность перемещения (валидных/не валидных yml файлов), в директории
определенных в конфигурационном файле парсера.
Так же автотест проверяет корректность работы самого модуля парсигна. 
***
Стек технологий:
- Java

Инструменты сборки:
- Maven

На вашей системе должны быть установленны:
1. Java 8
    * По [ссылке](http://barancev.github.io/how-to-install-java-on-windows/), вы можете прочесть информацию по установке
    java , а также получить рекомендации по настройке переменных окружения
2.  Maven 3.3.9
    * Скачать можете по [ссылке](https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip), а инструкцию по
    установке можете прочесть [тут](http://www.apache-maven.ru/install.html)

Сборка автотеста
=======================
1. Вам необходимо клонировать репозиторий.
    * Откройте командную строку и введите в нее *git clone https://github.com/neonet1984/testParser.git*
2. Далее вам нужно сконфигрировать автотест, ниже представлено описание файлов и параметров:
    * Файл *test/java/resources/runSuite.xml* - используеться для запуска сьютов
    * Файл *test/java/resources/masterSuite.xml* - содержит, набор сьютов, в нем находяться следующие параметры:
        1. *rootPathToParser* - в этом параметре, указываеться корневой путь, к парсеру <b>(обязательный параметр к изменению)</b>
        2. *namePropertiesFileParser* - в этом параметре, указываеться конфигурационный файл, используемый парсером
        3. *pathToNotValidYmlFile* - в этом параметре, указываеться относительный путь к не валидным yml файлам 
        4. *pathToValidYmlFile* - в этом параметре, указываеться относительный путь к валидным ямл файлам
        5. *pathToDirectoryExpectFile* - в этом параметре, указывается относительный путь к .properties файлам
    * Файл *test/resources/testCreatingDirectoriesFromConfig.xml* - содержит набор тест кейсов для тестированния корректности, созданных директорий исходя из конфигурации парсера
    * Файл *test/resources/testParsingFunctionality.xml* - содержит набор тест кейсов, для тестированния модуля, парсинга, ямл файлов
#####Примечание:
    Основной конфигурацией для автотеста, является изменение параметра rootPathToParser, указав этот параметр автотест прочтет кофигурационный файл парсера, и приступит к прогонке сьютов
Запуск автотеста
=================
<b>Обязательным условим</b>, являеться запущенный парсер. После чего вам необходимо зайти в папку *bin*, автотеста и запустть 
*startup.bat*