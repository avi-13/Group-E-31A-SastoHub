import products from './products.json'

export const getProductList = ()=>{

    return  products.map(product=>console.log('product :>> ', product))


}