const functionWithError = () => {throw  new Error('some error')}

try {
    functionWithError()
}catch (error){
    console.error(error)
    console.log(error.message)
}finally {
    console.log('Continue...')
}

//Пример говорит сам за себя