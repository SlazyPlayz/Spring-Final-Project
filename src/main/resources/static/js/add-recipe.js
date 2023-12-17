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
addItemBtn.addEventListener('click', addItem);

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

                const btn = document.getElementById('remove-' + itemName);
                btn.addEventListener('click', () => {
                    document.getElementById(itemName).hidden = true;
                    currentAmount.value = '';
                    itemExists.className = 'alert alert-warning d-none';
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
    }
}