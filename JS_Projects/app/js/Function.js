// Функция может быть : анонимной, присвоенна переменной, именнованой, аргументом при вызове другой функции, значением свойства объекта
// Функция в js - объект
// Функция console.dir возвращает свойства переданного объекта
let y // Переменная объявленная в глобальной области видимости , её значение undefined
function addition(a, b){
    let c
    c = a + b
    return a + b
}

// Если у функции нет вохвращаемого типа , то она возвращает undefined
// то есть функция всегда что-то овзвращает

function smallFunction(){}

// Внутри функции категорически не рекомендуется мутировать внешние объекты

person = {
    age : 21,
    name : 'tom'
}

//Вместо этого
function changeObj1(person){
    person.age = person.age + 10
    return person
}

//Делай это
function changeObj2(person){
    const newPerson = Object.assign({}, person)
    newPerson.age = 40;
    return newPerson
}

console.log(changeObj1(person))
console.log(changeObj2(person))


// Области видимости
function externalFunction(){ //Глобальная область видимости
    function innerFunction(){ //Внутрення область видимости функции externalFunction()
        let b = 1 //Внутрення область видимости(scope) функции innerFunction()
        return b++
    }
    //console.log(b)
}

//externalFunction()
//console.log(b) // b is not defined

//Далее будет расписан пример с функциональным выражением
//Функциональные выражения всегда анонимны
//Функциональные выражения можно присваивать переменной
//Можно использовать как аргумент в вызове другой функции(callback функции)
const myFunction = function(a, b) {
    return a + b
}
setTimeout(function (){
    console.log('Всё работает ' + myFunction(1, 3))
}, 2000)

//Стрелочные функции
// Стрелочная функция это выражение => они анонимны
//Традиционные функции не стоит использовать , т.к после её объявления и декларирования , можно присвоить переменной с таким же именем другое значение
let fun = (a, b) => {
    return a + b
}

// function f(){}
// const f = 20         Вызовет ошибку
// console.log(f())

//Если у стрелочной функции только один параметр , то скобки можно опустить. Пример:
const oneParamFunction = a => {
    return a
}

//Фигурные скобки можно опустить , если тело функции состоит из одного выражения
const functionWithoutBranch = (a, b) => a + b




//Значение параметров функции по умолчанию
//Пример функции с значением по умолчанию
const addPost = (post, addedAt = Date()) => ({ // Если хотим неявно вернуть объкт , то нужно использовать подобный синтаксис
    ...post,
    addedAt : addedAt
})

const post = {
    add : 'https/....'
}

console.log(addPost(post))
