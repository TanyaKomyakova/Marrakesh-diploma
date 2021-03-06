### Отчет о тестировании приложения "Марракэш"

#### Описание
Приложение представляет из себя веб-сервис для покупки тура по определенной цене 45 000 руб. с помощью
двух способов:

- Обычная оплата по дебетовой карте
- Уникальная технология: выдача кредита по данным банковской карты.

Предоставлен набор карт:

- "4444 4444 4444 4441", "status": "APPROVED"
- "4444 4444 4444 4442", "status": "DECLINED"

Приложение в собственной базе данных сохраняет информацию о стоимости тура, о том, каким способом был совершён платёж, успешно ли он был совершён.
Для того чтобы совершить покупку тура, необходимо вводить данные карты.

#### Тест-кейсы
- Всего составлено для проверки 16 тест-кейсов, (75% успешных, 25% неуспешных)
- Заведено 7 Code issue на сайте www.github.com:
  1. [Ошибка в платеже](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/1)
  2. [Ошибка сохранения суммы оплаты тура в базе данных](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/2)
  3. [Ошибка при заполнении имени владельца карты](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/3)
  4. [Лишнее предложение на главной странице тура "Марракэш"](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/4)
  5. [Ошибка в создании объекта в базе данных](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/5)
  6. [Не симметрично расположены данные на главной странице приложения](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/6)
  7. [В базе данных не сохраняются данные о покупке в кредит в колонке "credit_id"](https://github.com/TanyaKomyakova/Marrakesh-diploma/issues/7)

#### Рекомендации
Для того чтобы тест-кейсы давали 100% успешность, необходимо разработчикам устранить заведенные issue на сайте www.github.com

