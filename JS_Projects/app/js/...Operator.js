'use strict'

const button = {
    width : 200,
    height : 1400,
    color: 'black'
}

//  если у объекта button есть свойство с именем color, то значение в redButton будет перезаписано
const redButton = {
    ...button,
    color : 'red'
}

console.log(redButton)
console.log('\n')

//Слияние объектов

const buttonInfo = {
    text : 'Buy'
}

const buttonStyle = {
    width : 1400,
    height : 700,
    color : 'yellow'
}

const finalButton = {
    ...buttonInfo,
    ...buttonStyle
}

console.log(finalButton)

// Создание копии объкта finalButton
const finalButton2 = JSON.parse(JSON.stringify(finalButton))