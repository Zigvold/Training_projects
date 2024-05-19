const city = {
    people : 200_000,
    location : 'Russia',
    city : 'Petersburg',
    suburban :  {
        suburb1 : 'Slavanka',
        suburb2 : 'Pushkin'
    }
}

// Создание копий объекта city и их мутация

const cityCopy1 = city; // Просто копируем ссыку на объект city
// В этом случае мы создаём новый объек в памяти и присваеваем переменной новую ссылку
const cityCopy2 = Object.assign({}, city)
// Object - тип и класс в JavaScript, имеет множество своих методов
cityCopy2.people = 200
console.log(cityCopy1)
console.log(cityCopy2 + '\n')
// Стоит также отметить , что при создании нового экземпляра объекта как в 14 строке
// происходит неглубокое копирование , тоесть ссылка на вложенный объект будет скопирована
// из родительского объекта.

// 2 вариант создания копии объекта в js, аналогичен первому варианту(имеет похожие проблемы)
const cityCopy3 = {...city} // оператор разделения объекта на свойства
// 3 вариатн создания копии объекта в js, позволяет избежать проблемы с неглубоким копированием объкта
// Если изменять свойства вложенного объекта, подобной копии родительского объекта, в родителе ничего не изменится
const cityCopy4 = JSON.parse(JSON.stringify(city))
cityCopy4.suburban.suburb1 = 'Strange place'
console.log(cityCopy4)
console.log(city)
