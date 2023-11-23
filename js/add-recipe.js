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

const addIngredientBtn = document.getElementById('add-ingredient');
addIngredientBtn.addEventListener('click', addIngredient);
const ingredientsDiv = document.getElementById('ingredients');
const ingredientExists = document.getElementById('ingredient-exists-alert');

async function addIngredient() {
    const ingredientName = document.getElementById('ingredient').value;

    if (ingredientName.length > 0) {

        if (document.getElementById(ingredientName) == null) {

            ingredientsDiv.appendChild(await createIngredient(ingredientName));

            const btn = document.getElementById('btn-' + ingredientName);
            btn.addEventListener('click', () => {
                const ingredient = document.getElementById(ingredientName);
                ingredientsDiv.removeChild(ingredient);
            });

            ingredientExists.className = 'alert alert-warning d-none';

        } else {
            ingredientExists.className = 'alert alert-warning mt-1 mb-0 py-2';
        }
        
        ingredient.value = '';
    }
}

async function createIngredient(name) {
    const groupDiv = document.createElement('div');
    groupDiv.className= 'input-group mt-1';
    groupDiv.id = name;

    const textInput = document.createElement('input');
    textInput.type = 'text';
    textInput.name = 'ingredient';
    textInput.className = 'form-control bg-dark';
    textInput.value = name;
    textInput.disabled = true;

    const btn = document.createElement('button');
    btn.type = 'button';
    btn.id = 'btn-' + name;
    btn.className = 'input-group-text';

    const removeIcon = document.createElement('i');
    removeIcon.className = 'fa-solid fa-circle-minus';

    btn.appendChild(removeIcon);

    groupDiv.appendChild(textInput);
    groupDiv.appendChild(btn);

    return groupDiv;
}