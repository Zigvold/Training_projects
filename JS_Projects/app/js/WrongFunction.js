'use strict'// Запрещает использование необъявленных переменных

function wrongFunction(){ //Пример того как делать не стоит , ибо переменная а будет объявлена в глобальной области видимости
    a = true
    console.log(a)
}

wrongFunction()
console.log(a)