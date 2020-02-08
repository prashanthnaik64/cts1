const PRODUCTS_KEY = "products";

getProductsFromLocalStorage = () =>{
    let products=[];
    
    if(localStorage.getItem(PRODUCTS_KEY)){
        products=JSON.parse(localStorage.getItem(PRODUCTS_KEY));
    }

    return products;
}

addItemFormSubmit = () =>{
    let products = getProductsFromLocalStorage();

    let itemNameTextBox = document.querySelector("#name1");
    let itemNameTextBox1 = document.querySelector("#name2");
    let itemPriceTextBox = document.querySelector("#street");
    let itemQuantityTextBox = document.querySelector("#city");
    let itemQuantityTextBox1 = document.querySelector("#r");


    

    let product = {

        name:itemNameTextBox.value,
        name1:itemNameTextBox1.value,
        
        price:itemPriceTextBox.value,
        quantity:itemQuantityTextBox.value,
         quantity1:parseInt(itemQuantityTextBox1.value)
        // price:parseFloat(itemPriceTextBox.value),
         // quantity:parseInt(itemQuantityTextBox.value)
    };

    products.push(product);
    localStorage.setItem(PRODUCTS_KEY,JSON.stringify(products));
}

loadItems = () =>{
    let products = getProductsFromLocalStorage();

    let tableBody = document.querySelector("#prdData");

/*    products.forEach(product => {
        let prdRow = createProductRow(product);
        tableBody.append(prdRow);
    }); */

    for(let product of products){
        let prdRow = createProductRow(product);
        tableBody.append(prdRow);
    }
}

createProductRow = (product) =>{

    let nameCol = document.createElement("td");
    nameCol.textContent=product.name;
    

    let nameCol1 = document.createElement("td");
    nameCol1.textContent=product.name1;

    let priceCol = document.createElement("td");
    priceCol.textContent=product.price;

    let qtyCol = document.createElement("td");
    qtyCol.textContent=product.quantity;

let qtyCol1 = document.createElement("td");
    qtyCol1.textContent=product.quantity1;



    let prdRow = document.createElement("tr");
    prdRow.append(nameCol);
    prdRow.append(nameCol1);
    
    prdRow.append(priceCol);
    prdRow.append(qtyCol);
    prdRow.append(qtyCol1);


    return prdRow;
}