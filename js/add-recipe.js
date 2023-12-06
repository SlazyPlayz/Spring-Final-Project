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

const addItemBtn = document.getElementById('add-item');
addItemBtn.addEventListener('click', additem);
const itemsDiv = document.getElementById('items');
const itemExists = document.getElementById('item-exists-alert');

async function additem() {
    const itemName = document.getElementById('item').value;

    if (itemName.length > 0) {

        if (document.getElementById(itemName) == null) {

            itemsDiv.appendChild(await createItem(itemName));

            const btn = document.getElementById('btn-' + itemName);
            btn.addEventListener('click', () => {
                const item = document.getElementById(itemName);
                itemsDiv.removeChild(item);
                itemExists.className = 'alert alert-warning d-none';
            });

            itemExists.className = 'alert alert-warning d-none';

        } else {
            itemExists.className = 'alert alert-warning mt-1 mb-0 py-2';
        }
        
        item.value = '';
    }
}

async function createItem(name) {
    const groupDiv = document.createElement('div');
    groupDiv.className= 'input-group mt-1';
    groupDiv.id = name;

    const textInput = document.createElement('input');
    textInput.type = 'text';
    textInput.name = 'item';
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