## Рефлексия

Создать класс Injector, в котором был бы параметризированный метод inject, который принимал бы в качестве параметра объект любого класса и, используя механизмы рефлексии осуществлял поиск полей, помеченных
этой аннотацией  @AutoInjectable (в качестве типа поля используются некоторый интерфейс), и осуществлял бы инициализацию этих полей экземплярами классов, которые указаны в качестве реализации соответствующего интерфейса в некотором файле настроек (properites).