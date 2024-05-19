console.log('hello world')
//Если использовать ключевое словов let то мы создам изменяемую переменную
//Значение между объявлением и присваиванием у переменной будет значение undefined
let boolean
let number = 20
boolean = true

//Переменные объявленные с помощью операторов const, var, let видмы только в области того блока , в котором они были декларированны

//Оператор const используется для объявление константной переменной
//Значение переменной объявленой таким образом необходимо присваивать сразу
const  c = 10

let a
// console.log(a) //undefined
a = false
// console.log(a) //false
a = 22
// console.log(a + '\n') //22

//Функция log класса console возвращает тип undefined, он обычно не используется
// console.log(console.log(10))

const digital = 10 //Тип number
const line = 'string'//Тип String
const bool = true//Тип boolean
const undef = undefined//Тип undefined значение несуществует
const nothing = null//Тип null
const symbol = Symbol("symbol")//Тип Symbol
let obj = {
    a: 10,
    b: true
}//Ссылочный тип Object
const copyObj = obj //Объект в памяти остался в одном месте , copyObj копировал ссылку
copyObj.c = 'abc'
// console.log(copyObj.c)

const city = {
    location: 'Moscow',
    country: 'Russia'
}

//Извращения над объектами (json)

//Далее показана мутация объекта
console.log(city)
city.location = 'Petersburg'
console.log(city)
delete city.country //Удаление свойств объектов

const popularityProprietyName = 'popularity'
city[popularityProprietyName] = 2000
console.log(city)

//Вложенные объекты(свойства), вложенность может быть многоуровневая
const execution = {
    exist : true,
    temporary : 900
}
city.innerObj = execution
console.log(city)
delete city.innerObj

//Сокращённая форма записи свойств объёктов
const num = 213
const street = 'Petrogradskaya'

const school = {
    num,
    street
}
console.log(school)

//Объекты с функциями
const objectWithFunction = {
    helloFunction : function (){console.log('Hello from function ' + this.something)},
    something : 1000
}
//Если превратить объект в Json , то объявленные в нём функции будут опущены
console.log(JSON.stringify(objectWithFunction))

//Json - JavaScript Object Notation
//Также благодаря методу parse глобального объекта Json можно парсить объекты обратно в Json