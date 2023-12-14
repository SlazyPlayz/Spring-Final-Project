// document.addEventListener("DOMContentLoaded", function() {

//     let html = document.getElementsByTagName('html')[0];
//     let darkMode = document.getElementById('darkMode');
//     darkMode.setAttribute('checked', true);

//     darkMode.addEventListener('check', changeDarkMode);

//     function changeDarkMode(event) {
//         console.log('I got here')
//         let isDark = html.getAttribute('data-bs-theme') == 'dark';
//         if (isDark) {
//             darkMode.setAttribute('checked', false);
//             html.setAttribute('data-bs-theme', 'white');
//             console.log("It's dark");
//         } else {
//             darkMode.setAttribute('checked', true);
//             html.setAttribute('data-bs-theme', 'black');
//             console.log("It's white");
//         }
//     }   
// })

let items = new Map();

const addItemBtn = document.getElementById('add-item');
addItemBtn.addEventListener('click', addItem);

// const submitBtn = document.getElementById('btn-submit');
// submitBtn.addEventListener('click',  addIngredient)

function addItem() {

    const itemExists = document.getElementById('item-exists-alert');
    const itemNotExist = document.getElementById('item-not-exist-alert');

    const item = document.getElementById('item');
    const itemName = item.value.toLowerCase();

    if (itemName.length > 0) {

        if (document.getElementById(itemName) != null) {

            const currentItem = document.getElementById(itemName);

            if (currentItem.hidden) {
                currentItem.removeAttribute('hidden');

                const currentName = document.getElementById('item-' + itemName);
                const currentAmount = document.getElementById('amount-' + itemName);
                const amount = document.getElementById('amount');
                currentAmount.value = amount.value;

                items.set(itemName, amount.value);

                const btn = document.getElementById('remove-' + itemName);
                btn.addEventListener('click', () => {
                    document.getElementById(itemName).hidden = true;
                    currentAmount.value = '';
                    itemExists.className = 'alert alert-warning d-none';
                    items.delete(itemName);
                });

                document.getElementById('amount').value = '';
                item.value = '';
                itemExists.className = 'alert alert-warning d-none';

            } else {
                itemExists.className = 'alert alert-warning mt-1 mb-0 py-2';
                itemNotExist.className = 'alert alert-warning d-none';
            }

        } else {
            itemNotExist.className = 'alert alert-warning mt-1 mb-0 py-2';
            itemExists.className = 'alert alert-warning d-none';
        }

        const ingredientsList = document.getElementById("added-ingredients");
        ingredientsList.value = "";

        items.forEach((name, amount) => {
            ingredientsList.value += `${name}(${amount})`;
            if (name !== Array.from(items.keys())[items.keys.length - 1]) {
                ingredientsList.value+= '; ';
            }
        })

        console.log(ingredientsList.value);
    }
}

// function addIngredient(event) {
//
//     if (event) {
//         event.preventDefault();
//     }
//
//     const name = document.getElementById('name');
//     const description = document.getElementById('description');
//
//     const httpHeaders = {
//         method: 'POST',
//         body: JSON.stringify({ name, description, items })
//     };
//
//     fetch("https://localhost:8080/recipes/add", httpHeaders)
//         .catch(handleError);
// }
//
// function handleError(err) {
//     console.log(err);
// }