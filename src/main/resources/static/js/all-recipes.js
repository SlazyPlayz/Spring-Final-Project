function getAllRecipes() {

    const container = document.getElementById('recipes-container');

    fetch('https://localhost:8080/recipes/get')
        .then(response => response.json())
        .then(json => json.forEach(recipe => {

            const column = document.createElement('div');
            column.className = 'col-3';
            container.appendChild(column);

            const border = document.createElement('div');
            border.className = 'border border-2 rounded-2 p-0';
            column.appendChild(border);

            const card = document.createElement('div');
            card.className = 'card border-0 justify-content-around';
            border.appendChild(card);

            const img = document.createElement('img');
            img.src = recipe.imageUrl;
            img.className = 'img-fluid w-100 rounded-top-1';
            card.appendChild(img);

            const cardBody = document.createElement('div')
            cardBody.className = 'card-body';
            card.appendChild(cardBody);

            const cardTitle = document.createElement('div');
            cardTitle.className = 'card-title';
            cardBody.appendChild(cardTitle);

            const title = document.createElement('h2');
            title.textContent = recipe.name;
            cardTitle.appendChild(title);

            const cardText = document.createElement('p');
            cardText.className = 'card-text';
            cardText.textContent = recipe.description;

            const cardFooter = document.createElement('div');
            cardFooter.className = 'card-footer bg-dark border-0 px-0';
            cardBody.appendChild(cardFooter);

            const cardFooterSpan = document.createElement('span');
            cardFooterSpan.className = '';
            cardFooterSpan.textContent = recipe.authorName;
            cardFooter.appendChild(cardFooterSpan);

        }));
}